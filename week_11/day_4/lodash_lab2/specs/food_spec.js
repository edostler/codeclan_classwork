var assert = require('assert')
var Hero = require('../hero.js')
var Task = require('../task.js')
var Food = require('../food.js')
var Rat = require('../rat.js')

describe("Food", function(){
  beforeEach(function(){
    food1 = new Food("Steak", 60);
  });
  it("Has a name", function(){
    assert.strictEqual(food1.name, "Steak");
  });
  it("Has a replenishment value", function(){
    assert.strictEqual(food1.replenishment, 60);
  });
  it("Can set poisonous status to true", function(){
    food1.poison();
    assert.strictEqual(food1.poisonous, true);
  });
});
