const _ = require("lodash");

var Task = function(difficulty, urgency, reward){
  this.difficulty = difficulty;
  this.urgency = urgency;
  this.reward = reward;
  this.status = false;
}

Task.prototype.complete = function () {
  this.status = true;
};

module.exports = Task;
