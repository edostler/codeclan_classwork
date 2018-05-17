// Have seen objects like this
var myObject = {};
myObject.shape = "circle";
myObject.radius = 10;
var myObject = new Object();
myObject.size = 6;
myObject.colour = "red";

// Can also do this, but gets long winded with lots to new up
var house1 = {
  sqFeet: 2000,
  bathrooms: 2,
  bedrooms: 3
};

// So instead we do this
var House = function(sqFeet, bathrooms, bedrooms){
  this.sqFeet = sqFeet;
  this.bathrooms = bathrooms;
  this.bedrooms = bedrooms;
  this.numberOfRooms = function(){
    return this.bathrooms + this.bedrooms;
  }
};
var house1 = new House(2000, 2, 3);
var house2 = new House(1500, 1, 1);
var house3 = new House(3000, 3, 4);
console.log(house1.sqFeet);
console.log(house2.bedrooms);
console.log(house3.numberOfRooms());

// Here's another
var Office = function(desks, meetingRooms){
  this.desks = desks;
  this.meetingRooms = meetingRooms;
  this.averageDesksPerMeetingRoom = function(){
    return this.desks / this.meetingRooms;
  }
}
var office1 = new Office(20,4);
var office2 = new Office(50,7);
console.log(office1.averageDesksPerMeetingRoom());
console.log(office2.averageDesksPerMeetingRoom());
console.log(office1);

// Task: Planets and Solar System
var Planet = function(name){
  this.name = name;
};

var SolarSystem = function(){
  this.planets = [];
  this.addPlanet = function(planet){
    this.planets.push(planet);
  }
}

var planet1 = new Planet("Mercury");
var planet2 = new Planet("Venus");
var planet3 = new Planet("Earth");
var planet4 = new Planet("Mars");
var planet5 = new Planet("Jupiter");
var planet6 = new Planet("Saturn");
var planet7 = new Planet("Uranus");
var planet8 = new Planet("Neptune");

var solarSystem = new SolarSystem();

solarSystem.addPlanet(planet1);
solarSystem.addPlanet(planet2);
solarSystem.addPlanet(planet3);
solarSystem.addPlanet(planet4);
solarSystem.addPlanet(planet5);
solarSystem.addPlanet(planet6);
solarSystem.addPlanet(planet7);
solarSystem.addPlanet(planet8);

console.log(solarSystem);
