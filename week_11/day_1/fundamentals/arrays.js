// var pets = ["Blinky", "Twizzle", "Paggy"];
// // OR
// // var pets = new Array();
//
// console.log(pets);
//
// var drums = new Array();
// drums.push("yamaha");
// drums.push("gretsch");
//
// console.log(drums);
//
// console.log(pets[0]);
//
// console.log(pets[-1]);
//
// console.log(pets[10]);
//
// console.log(pets[2] = "Dora");
// console.log(pets);
//
// pets[10] = "Becky";
//
// console.log(pets);
//
// console.log(pets.length);
//
// var item1 = pets.shift();
//
// console.log(pets);
// console.log(item1);
//
// // pets.pop();
//
// console.log(pets);
//
// console.log(pets.slice(0, 2));
// console.log(pets.slice(1));
// console.log(pets.slice(1, -1));
// console.log(pets.slice(1, -5));
// console.log(pets.slice(1, 0));
//
//
// pets.splice(2, 1, "Dozy");
// console.log(pets);
//
//
// var indexToRemove = pets.indexOf("Dora");
// console.log(indexToRemove);
// pets.splice(indexToRemove, 1);
// console.log(pets);



var numbers = [1,2,3,4,5,6,7,8,9,10];
result = numbers.filter(number => number % 2 === 0);
console.log(result);

pets = ["Dora", "Dozy", "Paggy"];
var dPets = pets.filter(pet => pet.startsWith("D"));
console.log(dPets);

pets[10] = "New";
var realPets = pets.filter(pet => pet !== undefined);
console.log(realPets);
