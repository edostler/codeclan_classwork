// Athlete should have a hydration attribute that starts at 100.
// Athlete should have a distance covered attribute starts at 0.
// Athlete should be able to run: increasing distance, decreasing hydration.
// Athlete should not move when running dehydrated: hydration at 0;
// Athlete should be able to increase hydration by drinking from water bottle
// Use Mocha's beforeEach() to create a new instance of WaterBottle and Athlete before each test.

var assert = require("assert");
var Athlete = require("../athlete.js");
var WaterBottle = require("../water_bottle.js");

describe("Athlete", function(){
  beforeEach(function(){
    athlete = new Athlete();
    bottle = new WaterBottle();
  });
  it("Athlete should have a hydration attribute that starts at 100", function(){
    assert.strictEqual(athlete.hydration, 100);
  })
  it("Athlete should have a distance covered attribute starts at 0", function(){
    assert.strictEqual(athlete.distance, 0);
  })
  it("Athlete should be able to run: increasing distance, decreasing hydration", function(){
    athlete.run(20);
    assert.strictEqual(athlete.distance, 20);
    assert.strictEqual(athlete.hydration, 90);
  })
  it("Athlete should not move when running dehydrated: hydration at 0", function(){
    athlete.hydration = 0;
    athlete.run(20);
    assert.strictEqual(athlete.distance, 0);
    assert.strictEqual(athlete.hydration, 0);
  })
  it("Athlete should be able to increase hydration by drinking from water bottle", function(){
    athlete.hydration = 0;
    bottle.fill();
    athlete.drink(bottle, 20);
    assert.strictEqual(athlete.hydration, 20);
    assert.strictEqual(bottle.volume, 80);
  })
})
