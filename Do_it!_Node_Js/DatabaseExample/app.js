//Basic Module
var express = require('express'), http = require('http'), path = require('path');

//Express Module
var bodyParser = require('body-parser'), cookieParser = require('cookie-parser'),
  static = require('serve-static'), errorHandler = require('errorHandler');

var expressErrorHandler = require('express-error-handler');

var expressSession = require('express-session');

var app = express();

app.set('port', process.env.PORT || 3000);

app.use(bodyParser.urlencoded({extended: false}));

app.use(bodyParser.json());

app.use('/public', static(path.join(__dirname, 'public')));

app.use(cookieParser());

app.use(expressSession({
  secret:'my key',
  resave: true,
  saveUninitialized: true

}));

var MongoClient = require('mongodb').MongoClient;

var database;

function connectDB(){
  var databaseUrl = 'mongodb://localhost:27017/local';

  MongoClient.connect(databaseUrl, function(err, db){
    if(err) throw err;

    console.log('Database Connected : ' + databaseUrl);

    database = db.db('local');
  });
}

var authUser = function(database, id, password, callback){
  console.log('auth called');

  var users = database.collection('users');

  users.find({"id" : id, "password" : password}).toArray(function(err,docs){
    if(err){
      callback(err, null);
      return;
    }

    if(docs.length > 0){
      console.log('ID [%s], PASSWORD [%s] user found', id, password);
      callback(null, docs);
    } else{
      console.log('no User');
      callback(null,null);
    }
  })
}



var router = express.Router();

router.route('/process/login').post(function(req, res) {
	console.log('/process/login 호출됨.');

    // 요청 파라미터 확인
    var paramId = req.body.id || req.query.id;
    var paramPassword = req.body.password || req.query.password;

    console.log('요청 파라미터 : ' + paramId + ', ' + paramPassword);

    // 데이터베이스 객체가 초기화된 경우, authUser 함수 호출하여 사용자 인증
	if (database) {
		authUser(database, paramId, paramPassword, function(err, docs) {
			if (err) {throw err;}

            // 조회된 레코드가 있으면 성공 응답 전송
			if (docs) {
				console.dir(docs);

                // 조회 결과에서 사용자 이름 확인
				var username = docs[0].name;

				res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
				res.write('<h1>로그인 성공</h1>');
				res.write('<div><p>사용자 아이디 : ' + paramId + '</p></div>');
				res.write('<div><p>사용자 이름 : ' + username + '</p></div>');
				res.write("<br><br><a href='/public/login.html'>다시 로그인하기</a>");
				res.end();

			} else {  // 조회된 레코드가 없는 경우 실패 응답 전송
				res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
				res.write('<h1>로그인  실패</h1>');
				res.write('<div><p>아이디와 패스워드를 다시 확인하십시오.</p></div>');
				res.write("<br><br><a href='/public/login.html'>다시 로그인하기</a>");
				res.end();
			}
		});
	} else {  // 데이터베이스 객체가 초기화되지 않은 경우 실패 응답 전송
		res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
		res.write('<h2>데이터베이스 연결 실패</h2>');
		res.write('<div><p>데이터베이스에 연결하지 못했습니다.</p></div>');
		res.end();
	}

});

app.use('/', router);

var errorHandler = expressErrorHandler({
  static: {
    '404': './public/404.html'
  }
});

app.use(expressErrorHandler.httpError(404));
app.use(errorHandler);

http.createServer(app).listen(app.get('port'), function(){
  console.log('server started : ' + app.get('port'));

  connectDB();
});
