var http = require('http');

var server = http.createServer();

var port = 3000;
server.listen(port, function(){
  console.log('web server started : %d', port);
});

server.on('connection', function(socket){
  var addr = socket.address();
  console.log('Client Connected : %s, %d', addr.address, addr.port);

});

server.on('request', function(req, res){
  console.log('Client sent a request');

  res.writeHead(200, {"Content-Type": "text/html; charset=utf-8"});
  res.write("<!DOCTYPE html>");
  res.write("<html>");
  res.write(" <head>");
  res.write("<title>response page</title>");
  res.write("</head>");
  res.write("<body>");
  res.write("<h1>Response from nodeJS</h1>");
  res.write("</body>");
  res.write("</html>");
  res.end();  
});

server.on('close', function(){
  console.log('Server close');
});
