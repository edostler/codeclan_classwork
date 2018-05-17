var assert = require('assert')
var Hero = require('../hero.js')
var Task = require('../task.js')
var Food = require('../food.js')
var Rat = require('../rat.js')

describe("Task", function(){
  beforeEach(function(){
    task1 = new Task(8, 10, 500);
  });
  it("Has a difficulty", function(){
    assert.strictEqual(task1.difficulty, 8);
  });
  it("Has an urgency", function(){
    assert.strictEqual(task1.urgency, 10);
  });
  it("Has a reward", function(){
    assert.strictEqual(task1.reward, 500);
  });
  it("Has a completion status that starts false", function(){
    assert.strictEqual(task1.status, false);
  });
  it("Can set completion status to true", function(){
    task1.complete();
    assert.strictEqual(task1.status, true);
  });
});
