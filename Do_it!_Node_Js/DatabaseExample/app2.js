//Basic Module
var express = require('express'), http = require('http'), path = require('path');

//Express Module
var bodyParser = require('body-parser'), cookieParser = require('cookie-parser'),
  static = require('serve-static'), errorHandler = require('errorHandler');

var expressErrorHandler = require('express-error-handler');

var expressSession = require('express-session');

var mongoose = require('mongoose');

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

var UserSchema;

var UserModel;

function connectDB(){
  var databaseUrl = 'mongodb://localhost:27017/local';

  console.log('Trying DB Connect');
  mongoose.Promise = global.Promise;
  mongoose.connect(databaseUrl);
  database = mongoose.connection;

  database.on('error', console.error.bind(console, 'mongoose connection error'));
  database.on('open', function(){
    console.log('DB Connected : ' + databaseUrl);

    UserSchema = mongoose.Schema({
      id: String,
      name: String,
      password: String
    });
    console.log('UserSchema Defined');

    UserModel = mongoose.model('users', UserSchema);
    console.log('UserModel Defined');

  });

  database.on('disconnected', function(){
    console.log('disconnected. Try again');
    setInterval(connectDB, 5000);
  });

}

var addUser = function(database, id, password, name, callback) {
	console.log('addUser 호출됨 : ' + id + ', ' + password + ', ' + name);

	// UserModel 인스턴스 생성
	var user = new UserModel({"id":id, "password":password, "name":name});

	// save()로 저장 : 저장 성공 시 addedUser 객체가 파라미터로 전달됨
	user.save(function(err, addedUser) {
		if (err) {
			callback(err, null);
			return;
		}

	    console.log("사용자 데이터 추가함.");
	    callback(null, addedUser);

	});
};

var authUser = function(database, id, password, callback){
  console.log('auth called');

  UserModel.find({"id": id, "password": password}, function(err, results){
    if(err){
      callback(err, null);
      return;
    }

    console.log('ID [%s], PW [%s] user result : ', id, password);
    console.dir(results);

    if(results.length > 0){
      console.log('Found.', id, password);
      callback(null, results);
    } else {
      console.log('Not Found.', id, password);
      callback(null, null);
    }

  });


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


router.route('/process/adduser').post(function(req, res) {
	console.log('/process/adduser 호출됨.');

    var paramId = req.body.id || req.query.id;
    var paramPassword = req.body.password || req.query.password;
    var paramName = req.body.name || req.query.name;

    console.log('요청 파라미터 : ' + paramId + ', ' + paramPassword + ', ' + paramName);

    // 데이터베이스 객체가 초기화된 경우, addUser 함수 호출하여 사용자 추가
	if (database) {
		addUser(database, paramId, paramPassword, paramName, function(err, addedUser) {
			if (err) {throw err;}

            // 결과 객체 있으면 성공 응답 전송
			if (addedUser) {
				console.dir(addedUser);

				res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
				res.write('<h2>사용자 추가 성공</h2>');
				res.end();
			} else {  // 결과 객체가 없으면 실패 응답 전송
				res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
				res.write('<h2>사용자 추가  실패</h2>');
				res.end();
			}
		});
	} else {  // 데이터베이스 객체가 초기화되지 않은 경우 실패 응답 전송
		res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
		res.write('<h2>데이터베이스 연결 실패</h2>');
		res.end();
	}

});
