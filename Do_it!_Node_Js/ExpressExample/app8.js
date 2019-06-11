var http = require('http');
var express = require('express');
var path = require('path');

var bodyParser = require('body-parser');
var static = require('serve-static');

var app = express();
var router = express.Router();

app.set('port', process.env.POST || 3000);

app.use(bodyParser.urlencoded({extended: false}));

app.use(bodyParser.json());

app.use('/', static(path.join(__dirname, 'public')));


app.use(function(req,res, next){
  console.log('Middle 1');

  var paramId = req.body.id || req.query.id;
  var paramPassword = req.body.password || req.query.password;

  res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
  res.write('<h1>Express server replied</h1>');
  res.write('<div><p>param id : ' + paramId + '</p></div>');
  res.write('<div><p>Param Password : ' + paramPassword + '</p></div>');
  res.end();

});

app.use('/', router);

router.route('/process/login').post(function(req,res){
  console.log('/process/login proceed');

  var paramId = req.body.id || req.query.id;
  var paramPassword = req.body.password || req.query.password;

  res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
  res.write('<h1>Express server replied</h1>');
  res.write('<div><p>param id : ' + paramId + '</p></div>');
  res.write('<div><p>Param Password : ' + paramPassword + '</p></div>');
  res.write("<br><br><a href='/public/login2.html'>back to Login</a>");
  res.end();


});

http.createServer(app).listen(3000, function(req, res){
    console.log('Express Server Started at 3000');


});
