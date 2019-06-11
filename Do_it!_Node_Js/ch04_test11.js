var fs = require('fs');

var infile = fs.createReadStream('./output.txt', {flags: 'r'});
var outfile = fs.createWriteStream('./output2.txt', {flags: 'w'});

infile.on('data', function(data){
  console.log('data',data);
  outfile.write(data);
});

infile.on('end', function(){
  console.log('exit');
  outfile.end(function(){
      console.log('file write done');
  });
});
