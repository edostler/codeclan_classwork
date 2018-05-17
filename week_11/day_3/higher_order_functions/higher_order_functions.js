// setTimeout(function(){
//   console.log("I am called after 3000 milleseconds");
// },3000);

const thingToHappen = function(){
  console.log("I am called after a delay");
};
// setTimeout(thingToHappen, 3000);

setInterval(thingToHappen, 3000);
