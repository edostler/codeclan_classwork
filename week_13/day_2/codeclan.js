use codeclan;
db.dropDatabase();

db.students.insert([{
  name: "Chris",
  favFood: "Pizza"
},
{
  name: "Y Danny",
  favFood: "Burgers"
}]);

db.students.find();
db.instructors.insert([{
  name: "Colin",
  favFood: "Knowledge"
},
{
  name: "Louise",
  favFood: "Peanut Butter"
}]);

db.instructors.find();
show collections;
