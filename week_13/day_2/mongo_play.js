use farm;
db.dropDatabase();

use farm;
db.animals.insert({
  name: "Erik",
  type: "Polar Bear"
});
db.animals.insert({
  name: "Ed",
  type: "Dog"
});

db.animals.find();
db.animals.find({name: "Ed"});

db.animals.update({name: "Ed"}, {
  $set: {type : "Goose"}
});
db.animals.find();

db.animals.remove({name: "Ed"});
db.animals.find();
