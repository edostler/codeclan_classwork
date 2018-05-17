// Create a function that takes in the first name and surname, and speaks eg "Howdy, I am Rick Henry"
// Create a multiply function, returning the result.
// Create a function that takes in an array and returns the first element.
// Create a function that takes in a list of names of any length, and prints them all to screen.
// Create an array of animal names and a function that adds the animals to a farm array and prints the names to the console.

const welcome = function(firstName, lastName){
  return `Howdy, I am ${firstName} ${lastName}`;
}
console.log(welcome("Ed", "Ostler"));


const multiply = function(num1, num2){
  return num1 * num2;
}
console.log(multiply(3,5));


const multiplyLots = function(){
  let total = arguments[0];
  for (let i = 0; i < (arguments.length - 1); i++){
    total = total * arguments[(i+1)];
  }
  return total;
}
console.log(multiplyLots(1,2,3,4,5));


const firstElementOfArray = function(petArray){
  return petArray[0];
}
console.log(firstElementOfArray(["dog", "cat", "rabbit"]));


const printArray = function(){
  for (name of arguments) {
    console.log(name);
  }
}
printArray("Ed", "Phil", "Emma");


const animals = ["pig", "horse", "sheep"]
const moveAnimals = function(animalArray){
  const animalFarm = animalArray.slice(0);
  for (animal of animalFarm) {
    console.log(animal);
  }
}
moveAnimals(animals);
