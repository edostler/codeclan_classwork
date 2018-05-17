// ```Create a bear object that has a type, a name, a belly and an eat method. The eat method should add something to the bear's belly.```

const bear = {
  type: "Grizzly",
  name: "G",
  belly: [],
  eat: function(fish){
    this.belly.push(fish);
  }
};

console.log("My hungry bear:", bear);
bear.eat("fish");
console.log("My full bear:", bear);
