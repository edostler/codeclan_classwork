var pets = ["dog", "cat", "snake", "parrot"];

for (var i = 0; i < pets.length; i++) {
  console.log(pets[i]);
}

for (var pet of pets) {
  console.log(pet);
}

for (var pet in pets) {
  console.log(pet);
}

var person = {
  "name": "Ed",
  "age": 31
};
for (var key in person) {
  console.log(key);
  console.log(person[key]);
}

var x = 0;
while(x <10){
  console.log("loop " + x);
  x++;
}
