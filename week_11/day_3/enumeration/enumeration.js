const numbers = [1,2,3,4,5];
// for (let number of numbers){
//   console.log(number);
// }

// numbers.forEach(function(number){
//   console.log(number);
// });

// const thingToDoToEachNumber = function(number){
//   console.log(number);
// }
// numbers.forEach(thingToDoToEachNumber);

Array.prototype.ourForEach = function(callback){
  // callback is the function to call against each element
  // this is the instance of the array we are dealing with
  // console.log(this);
  for (let element of this) {
    callback(element);
  }
};

const printElement = function(number){
  console.log(number);
};


// numbers.ourForEach(function(number){
//   console.log(number);
// });

numbers.ourForEach(printElement);
