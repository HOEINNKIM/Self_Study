console.log('argv attribute : ' + process.argv.length);
console.dir(process.argv);

if(process.argv.length > 2){
    console.log('Value of Third parameter : %s', process.argv[2]);
}

process.argv.forEach(function(item, index){
    console.log(index + ' : ' + item);
    
});