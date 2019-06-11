var fs = require('fs');

fs.readFile('./package.json', 'utf8', function(err, data){
  console.log(data);
});

console.log('request reading package.json');
