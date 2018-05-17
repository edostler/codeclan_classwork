var assert = require('assert')
var Record = require('../record.js')
var Store = require('../store.js')
var Customer = require('../customer.js')

describe("Record", function(){
  beforeEach(function(){
    record1 = new Record("Blink-182", "Take Off Your Pants And Jacket", "Punk-Pop", 899);
  });
  it("Has an artist", function(){
    assert.strictEqual(record1.artist, "Blink-182");
  });
  it("Has a title", function(){
    assert.strictEqual(record1.title, "Take Off Your Pants And Jacket");
  });
  it("Has a genre", function(){
    assert.strictEqual(record1.genre, "Punk-Pop");
  });
  it("Has a price", function(){
    assert.strictEqual(record1.price, 899);
  });
  it("Can print out records properties as a string", function(){
    assert.strictEqual(record1.printProperties(), "Blink-182: Take Off Your Pants And Jacket (Punk-Pop) - £8.99")
  })
});
