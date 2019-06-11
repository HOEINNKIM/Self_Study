var http = require('http');
var fs = require('fs');

var server = http.createServer();

var port = 3000;
server.listen(port, function(){
  console.log('web server started');
});

server.on('request', function(req, res){
  console.log('request ordered');

  var filename = '/Users/hoeinnkim/Desktop/house.png';
  fs.readFile(filename, function(err, data){
    res.writeHead(200, {"Content-Type": "image/png"});
    res.write(data);
    res.end();
  });
});
