// INSIDE A FUNCTION -> ENVIRONMENT
// function add(a, b){
//   console.log(this);
//   this.myNumber = 20;
//   return a + b;
// }
// HERE THIS IS REFERRING TO THE ENVIRONMENT, NODE HERE, THE BROWSER IF ON A FRONTEND ENVIRONMENT
// add(5, 3);
// window.myNumber;
// THIS EXAMPLE DOESN'T WORK IN NODE BECAUSE IT IS REFERRING TO WINDOW

// INSIDE AN OBJECT -> OBJECT
// var car = {
//   speed: 0,
//   accelerate: function(){
//     console.log(this);
//     this.speed += 10;
//   },
//   decelerate: function(){
//     this.speed -= 10;
//   }
// }
// car.accelerate();
// console.log(car.speed);

// INSIDE A CONSTRUCTOR -> INSTANCE
function Animal(type, legs){
  this.type = type;
  this.legs = legs;
  this.logInfo = function(){
    console.log(this === myCat);
    console.log("The " + this.type + " has " + this.legs + " legs");
  }
}
var myCat = new Animal("cat", 4);
myCat.logInfo();

// INSDIE A FUNCTION BEING USED AS A CALLBACK -> FUNCTION CALLING THE CALLBACK
setTimeout(myCat.logInfo, 1000);
// AFTER THE DELAY THE CONSTRUCTOR LOSES IT'S THIS, SO WE NEED TO BIND IT
setTimeout(myCat.logInfo.bind(myCat), 2000);
