// water bottle should be empty(X)
// should go to 100 when filled
// should go down by 10 when drank
// should go to 0 when emptied
// should not be able to go below 0
// Water Bottle Lab Extension
// Create and test a constructor for athlete objects.
//
var assert = require("assert");
var WaterBottle = require("../water_bottle.js");
describe("Water Bottle", function(){
  beforeEach(function(){
    bottle = new WaterBottle();
  });
  it("should be empty at the start", function(){
    assert.strictEqual(bottle.volume, 0);
  });
  it("should go to 100 when filled", function(){
    bottle.fill();
    assert.strictEqual(bottle.volume, 100);
  });
  it("should go down by 10 when dring 10", function(){
    bottle.fill();
    bottle.drink(10);
    assert.strictEqual(bottle.volume, 90);
  });
  it("should go to 0 when emptied", function(){
    bottle.fill();
    bottle.empty();
    assert.strictEqual(bottle.volume, 0);
  });
  it("should not be able to go below 0", function(){
    bottle.drink();
    assert.strictEqual(bottle.volume, 0);
  });
});
