// JS Day 1 Homework
//
// Go through each sample code and work out what the output will be and explain what happened.
//
// Episode 1
var name = 'Keith';
var printName = function() {
  console.log('My name is ' + name );
};
printName();
// My name is Keith - name is declared globally so is accessible when invoking the function.

// Episode 2
score = 5;
var result = function() {
  var score = 3;
  return score;
};
console.log(result());
// 3 - although score is declared locally within the function the return statement brings it out.

// Episode 3
var myAnimals = ['Chickens', 'Cats', 'Rabbits'];
var listAnimals = function() {
  myAnimals = ['Ducks', 'Dogs', 'Lions'];
  for(var i=0;i<myAnimals.length; i++){
    console.log(i + ": " + myAnimals[i]);
  }
}
listAnimals();
// 0: Ducks 1: Dogs 2: Lions - similarly to the last question, the console.log statement prints out the variable from within the function, but in this case the variable within is global and could have been accessed directly.

// Episode 4
var suspectOne = 'Jay';
var suspectTwo = 'Val';
var suspectThree = 'Keith';
var suspectFour = 'Rick';
var allSuspects = function() {
  var suspectThree = 'Harvey'
  console.log('Suspects include: ' + suspectOne + ', ' + suspectTwo + ', ' + suspectThree + ', ' + suspectFour)
};
allSuspects();
console.log( 'Suspect three is:' + suspectThree );
// Suspects include: Jay, Val, Harvey, Rick Suspect three is:Keith - Here the function can print out the global variables but updates one locally when it is invoked, and then when the 2nd output is called it can't access the locally updated variable and so calls the global version.

// Episode 5
var detective = {
  name : 'Ace Ventura',
  pet : 'monkey'
};
var printName = function(detective) {
  return detective.name
};
var detectiveInfo = function() {
  detective['name'] = 'Poirot'
  return printName(detective);
};
console.log(detectiveInfo());
// Poirot - the name of the global variable detective is updated in the 2nd function and then returned and printed.

// // Episode 6
var murderer = 'rick';
var outerFunction = function() {
  var murderer = 'marc';
  var innerFunction = function() {
    murderer = 'valerie';
  }
  innerFunction();
}
outerFunction();
console.log('the murderer is ', murderer);
// the murderer is  rick - I actually thought this would be valerie, because that line is global and called last, but it seems that because murderer was first declared globally as rick that this can't be overwritten.

// Episode 7 - Make up your own episode/s!
// Make up your own episode which can be whatever you wish and the rest of the class will work out together what happened and what the output will be.
const character = {
  name : "Conan the Barbarian",
  age : 90,
  weapon: "battle-axe"
};

character.name = "Cohen the Barbarian";

const getProperties = function(character){
  const getName = function(character) {
    return character.name;
  };
  let getAge = function(character) {
    return character.age;
  };
  var getWeapon = function(character) {
    return character.weapon;
  };
  console.log(getName(character), getAge(character), getWeapon(character));
}
getProperties(character);
