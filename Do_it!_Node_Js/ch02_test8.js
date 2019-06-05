var path = require('path');

var directories = ["users", "mike", "docs"];
var docsDirectory = directories.join(path.sep);
console.log('Working Directory : %s', docsDirectory);

var curPath = path.join('/Users/mike', 'notepad.exe');
console.log('File Path : %s', curPath);

var filename = 'C:\\Users\\mike\\notepad.exe';
var dirname = path.dirname(filename);
var basename = path.basename(filename);
var extname = path.extname(filename);

console.log('Directory :  %s, File Name : %s, Ext : %s', dirname, basename, extname);