process.on('exit', function(){
  console.log('Event Occured');
});

setTimeout(function(){
  console.log('Try system exit after 2 sec');

  process.exit();
}, 2000);
