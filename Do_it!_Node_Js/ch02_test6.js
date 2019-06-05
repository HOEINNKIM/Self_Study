var nconf = require('nconf');
nconf.env();

console.log('OS Config Values : %s', JSON.stringify(nconf.env()));