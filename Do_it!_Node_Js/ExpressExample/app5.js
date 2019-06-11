var http = require('http');
var express = require('express');

var app = express();

app.use(function(req,res, next){
  console.log('Middle 1');

  res.redirect('http://google.co.kr');

});

http.createServer(app).listen(3000, function(){
    console.log('Express Server Started at 3000');
});
