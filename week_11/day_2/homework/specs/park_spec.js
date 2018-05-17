var assert = require("assert");
var Dinosaur = require("../dinosaur.js");
var Park = require("../park.js");

describe("Park", function(){
  beforeEach(function(){
    park = new Park();
    dino1 = new Dinosaur("Velociraptor", 4);
    dino2 = new Dinosaur("Velociraptor", 2);
    dino3 = new Dinosaur("Triceratops", 1);
    dino4 = new Dinosaur("Stegasaurus", 5);
    dino5 = new Dinosaur("Velociraptor", 8);
  });
  it("Park has an enclosure that starts empty", function(){
    assert.deepStrictEqual(park.enclosure, []);
  });
  it("Can add dino to enclosure", function(){
    park.add(dino1);
    assert.deepStrictEqual(park.enclosure, [dino1]);
  });
  it("Can remove all dinos of a given type", function(){
    park.add(dino1);
    park.add(dino2);
    park.add(dino3);
    park.add(dino4);
    park.add(dino5);
    park.remove(dino1.type);
    assert.deepStrictEqual(park.enclosure, [dino3, dino4]);
  })
  it("Get all dinos with annualOffspring greater than X", function(){
    park.add(dino1);
    park.add(dino2);
    park.add(dino3);
    park.add(dino4);
    park.add(dino5);
    assert.deepStrictEqual(park.breeders(2), [dino1, dino4, dino5]);
  });
  it("Calculate number of dinos after 1 year starting with 1 dino", function(){
    park.add(dino1);
    const enclosure = park.enclosure;
    assert.strictEqual(park.calculate(enclosure).length, 5);
  });
  it("Calculate number of dinos after 1 year starting with 2 dinos", function(){
    park.add(dino1);
    park.add(dino2);
    const enclosure = park.enclosure;
    assert.strictEqual(park.calculate(enclosure).length, 8);
  });
  it("Calculate number of dinos after 2 years starting with 1 dino", function(){
    park.add(dino1);
    const enclosure = park.enclosure;
    assert.strictEqual(park.calculate(park.calculate(enclosure)).length, 25);
  });
  it("Calculate number of dinos after 2 years starting with 2 dinos", function(){
    park.add(dino1);
    park.add(dino2);
    const enclosure = park.enclosure;
    assert.strictEqual(park.calculate(park.calculate(enclosure)).length, 34);
  });
  it("Calculate number of dinos after 5 years starting with 5 dinos", function(){
    park.add(dino1);
    park.add(dino2);
    park.add(dino3);
    park.add(dino4);
    park.add(dino5);
    const enclosure = park.enclosure;
    assert.strictEqual(park.calculate(park.calculate(park.calculate(park.calculate(park.calculate(enclosure))))).length, 70225);
  });
});
