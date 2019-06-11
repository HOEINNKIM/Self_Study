process.on('tick', function(count){
    console.log('tick event occured : %s', count);
});

setTimeout(function(){
    console.log('tick event after 2sec.')

    process.emit('tick',2);
},2000);
