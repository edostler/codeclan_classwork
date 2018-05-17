var Athlete = function(){
  this.hydration = 100;
  this.distance = 0;
}

Athlete.prototype.run = function (distance) {
  if (this.hydration >= distance) {
    this.distance += distance;
    this.hydration -= (distance / 2);
  }
  else {
    this.distance -= this.distance;
    this.hydration -= (this.hydration / 2);
  }
};

Athlete.prototype.drink = function (bottle, volume) {
  this.hydration += volume;
  bottle.drink(volume);
};


module.exports = Athlete;
