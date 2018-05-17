const _ = require("lodash");

var Hero = function(name, favouriteFood){
  this.name = name;
  this.health = 100;
  this.favouriteFood = favouriteFood;
  this.talk = function(){
    return "Hi, I'm " + this.name;
  }
  this.tasks = [];
  this.dead = false;
}

Hero.prototype.add = function (task) {
  this.tasks.push(task);
};

Hero.prototype.changeHealth = function (value) {
  this.health += value;
  if (this.health <= 0) {
    this.dead = true;
    this.health = 0;
  }
};

Hero.prototype.eat = function (food) {
  let replenishment = food.replenishment;
  if (food.poisonous === true) {
    replenishment = -50;
  }
  else if (this.favouriteFood === food.name) {
    replenishment = food.replenishment*1.5;
  }
  this.changeHealth(replenishment);
};

Hero.prototype.sortTasks = function (sortingType) {
  return _.sortBy(this.tasks, sortingType);
};

Hero.prototype.completeTask = function (task) {
  task.complete();
};

Hero.prototype.getCompletedTasks = function () {
  return _.filter(this.tasks, task => task.status === true);
};

Hero.prototype.getIncompleteTasks = function () {
  return _.filter(this.tasks, task => task.status === false);
};

Hero.prototype.die = function () {
  this.dead = true;
};

Hero.prototype.stomp = function (rat) {
  rat.decreaseHealth(30);
};

module.exports = Hero;
