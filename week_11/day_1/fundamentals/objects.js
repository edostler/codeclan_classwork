const myPerson = {
  name: "Ed",
  age: 31,
  weapon: "cutlass",
  talk: function(){
    console.log("shiver me timbers, my name is " + this.name);
  }
};
console.log("my person:", myPerson);

console.log("my person's weapon:", myPerson.weapon);

myPerson.name = "Ed Ostler",
myPerson.age += 1;
console.log("my person:", myPerson);

myPerson.occupation = "Pirate";
console.log("my person:", myPerson);

myPerson.talk();

const object = {};
const anotherObject = Object.create(null);
const yetAnotherObject = new Object();

console.log(object, anotherObject, yetAnotherObject);

console.log("my person's name:", myPerson["name"]);

const keyToAccess = 'age';
console.log("my person's age:", myPerson[keyToAccess]);

const keys = Object.keys(myPerson);
for(let key of keys){
  console.log("key:", key + ",", "value:", myPerson[key]);
}
