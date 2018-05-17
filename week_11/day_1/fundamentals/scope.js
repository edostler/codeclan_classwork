const talk = function(){
  const name = "Ed";
  console.log("My name is " + name);
};
talk();
const walk = function(){
  console.log(name + " is walking");
};
// // OUT OF SCOPE
// walk();
// console.log("accessing name:", name);

// GLOBAL
const name2 = "Ed";
const talk2 = function(){
  console.log("My name is " + name2);
};
talk2();
const walk2 = function(){
  console.log(name2 + " is walking");
};
walk2();
console.log("accessing name:", name2);



const globalVariable = 99;

const separateFunction = function() {
  separateA = 2;
};

const outerFunction = function() {
  const outerA = 1;
  separateFunction();
  const innerFunction = function() {
    console.log('outerA ', outerA);
    console.log('globalVariable', globalVariable)
    console.log('separateA ', separateA);
  };

  innerFunction()
};

outerFunction();
