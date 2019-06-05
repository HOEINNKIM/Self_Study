var calc = require('./calc');
console.log('After Module : calc.add : %d', calc.add(10,10));

var calc2 = require('./calc2');
console.log('After Seperating Module : calc2.add : %d', calc2.add(10,10));
