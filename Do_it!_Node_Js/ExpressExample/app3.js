var http = require('http');
var express = require('express');

var app = express();

app.use(function(req,res, next){
  console.log('Middle 1');

  req.user = 'hoe';
  next();
});

app.use('/', function(req,res,next){
  console.log('Middle 2');

  res.writeHead('200', {'Content-Type':'text/html;charset=utf8'});
  res.end("<h1>Express : " + req.user + "'s Server</h1>");

})


http.createServer(app).listen(3000, function(){
    console.log('Express Server Started at 3000');
});
