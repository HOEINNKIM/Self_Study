var os = require('os');

console.log('Hello!');
console.log('hostname : %s', os.hostname());
console.log('memory : %d/%d', os.freemem(), os.totalmem());
console.log('CPU Info\n');
console.dir(os.cpus());
console.log('Network Interface Info\n');
console.dir(os.networkInterfaces());