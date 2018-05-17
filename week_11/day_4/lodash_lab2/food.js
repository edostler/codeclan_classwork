const _ = require("lodash");

var Food = function(name, replenishment){
  this.name = name;
  this.replenishment = replenishment;
  this.poisonous = false;
}

Food.prototype.poison = function () {
  this.poisonous = true;
};

module.exports = Food;
