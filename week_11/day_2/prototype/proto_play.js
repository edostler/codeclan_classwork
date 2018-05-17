// var myPerson = Object.create(null);
// myPerson.walk = function(){
//   console.log("left right left right");
// }
//
// var wisePerson = {
//   wisdom: function(){
//     console.log("Commit often");
//   }
// }
//
// // This overwrites the first constructors and function
// var myPerson = Object.create(wisePerson);
// myPerson.walk = function(){
//   console.log("left right left right");
// }
// myPerson.wisdom();
//
// // WE WON'T DO IT LIKE THE ABOVE, IT'S RUBBISH

// // We could construct and new a fish like this, but if all thefish swim differently then we'd need to make lots of swim methods...
// var Fish = function(name, colour){
//   this.name = name;
//   this.colour = colour;
//   this.swim = function(){
//     console.log("Splash");
//   }
// }
//
// var myFish = new Fish("Nemo", "Orange");
//
// myFish.swim();
//
// // ...instead we are going to store the swim method in the prototype...this is like using an abstract class in Java...
// var Fish = function(name, colour){
//   this.name = name;
//   this.colour = colour;
// }
//
// Fish.prototype =
//   swim: function(){
//     console.log("Splash");
//   }
// }
//
// var myFish = new Fish("Nemo", "Orange");
// myFish.swim();

// We can also pass methods into the prototype method
var Fish = function(name, colour){
  this.name = name;
  this.colour = colour;
}

Fish.prototype = {
  swim: function(swimType){
    console.log(swimType);
  }
};

var myFish = new Fish("Nemo", "Orange");
myFish.swim("Splish");

// We can also call to find out what is in the prototype
Object.getPrototypeOf(myFish);
console.log(Object.getPrototypeOf(myFish));
