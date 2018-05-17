var assert = require('assert')
var Hero = require('../hero.js')
var Task = require('../task.js')
var Food = require('../food.js')
var Rat = require('../rat.js')

describe("Rat", function(){
  beforeEach(function(){
    rat1 = new Rat();
    food1 = new Food("Steak", 60);
  });
  it("Has health 25 at start", function(){
    assert.strictEqual(rat1.health, 25);
  });
  it("Can decrease health by passed in value", function(){
    rat1.decreaseHealth(10);
    assert.deepStrictEqual(rat1.health, 15);
  });
  it("Can poison food", function(){
    rat1.poisonFood(food1);
    assert.deepStrictEqual(food1.poisonous, true);
  });
  it("Has a dead status that starts false", function(){
    assert.strictEqual(rat1.dead, false);
  });
  it("Can set dead status to true", function(){
    rat1.die();
    assert.strictEqual(rat1.dead, true);
  });
  it("Rat can die if health reaches 0", function(){
    rat1.decreaseHealth(30)
    assert.deepStrictEqual(rat1.health, 0);
    assert.deepStrictEqual(rat1.dead, true);
  });
});
