const _ = require("lodash");

var Rat = function(){
  this.health = 25;
  this.dead = false;
}

Rat.prototype.decreaseHealth = function (value) {
  this.health -= value;
  if (this.health <= 0) {
    this.dead = true;
    this.health = 0;
  }
};

Rat.prototype.poisonFood = function (food) {
  food.poison();
};

Rat.prototype.die = function () {
  this.dead = true;
};

module.exports = Rat;
