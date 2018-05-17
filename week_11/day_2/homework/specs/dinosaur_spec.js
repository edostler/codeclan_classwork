var assert = require("assert");
var Dinosaur = require("../dinosaur.js");
var Park = require("../park.js");

describe("Dinosaur", function(){
  beforeEach(function(){
    dino1 = new Dinosaur("Velociraptor", 22);
  });
  it("Dino has a type", function(){
    assert.strictEqual(dino1.type, "Velociraptor");
  });
  it("Dino has an annualOffspring", function(){
    assert.strictEqual(dino1.annualOffspring, 22);
  });
});
