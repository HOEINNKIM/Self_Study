var url = require('url');

var curURL = url.parse('https://m.search.naver.com/search.naver?query=steve+jobs&where=m&sm=mtp_hty');

var curStr = url.format(curURL);

console.log('Address : %s', curStr);
console.dir(curURL);

var querystring = require('querystring');
var param = querystring.parse(curURL.query);

console.log('query : %s', param.query);
console.log('request parameter : %s', querystring.stringify(param));
