var http = require('http');

var server = http.createServer();

var port = 3000;
var host = '10.10.15.136';

// server.listen(port, function(){
//   console.log('web server started. : %d', port);
// });


server.listen(port, host, '50000', function(){
  console.log('web server started. : %s, %d', host, port);
});
