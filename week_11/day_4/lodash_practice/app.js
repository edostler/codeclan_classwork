const _ = require("lodash");

const people = [
  {name: "Ed", age: 31, favouriteCheese: "Brie"},
  {name: "Christie", age: 30, favouriteCheese: "Jarlsberg"},
  {name: "Ellie", age: 37, favouriteCheese: "Manchego"},
  {name: "Louise", age: 29, favouriteCheese: "Brie"}
];

// console.log(_.filter(people, person => person.favouriteCheese === "Brie"));
// LODASH GIVES US SOME ALTERNATIVES:
// console.log(_.filter(people, {favouriteCheese: "Brie"}));

// console.log(_.sortBy(people, "name"));
// console.log(_.sortBy(people, "age"));
// console.log(_.sortBy(people, "age", "name"));

// let youngPeople = _.remove(people, function(person){
//   return person.age < 37;
// });
// let youngPeople = _.remove(people, (person) => person.age < 37);
// console.log(people);

// let avgAge = _.meanBy(people, "age");
// console.log(avgAge);

numbers = [1, 1, 2, 3, 5, 6, 7, 9];
numbers2 = [1, 4, 6, 7, 10];

let not1 = _.without(numbers, 1);
// console.log(not1);

let unique = _.uniq(numbers);
// console.log(unique);

let intersection = _.intersection(numbers, numbers2);
// console.log(intersection);

let partition = _.partition(people, person => person.age < 37);
// console.log(partition);

let groupBy = _.groupBy(people, "favouriteCheese");
// console.log(groupBy);

let random = _.random(1, 10);
console.log(random);

_.times(5, () => console.log("Hi"));

let arr = _.range(5);
console.log(arr);
