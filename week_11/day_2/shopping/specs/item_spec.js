// We need to find the total cost of the items contained in a shopping basket.
//
// Items should have a name, price and boolean value that determines whether or not they are eligible for a buy one get one free discount.
// A shopping basket can have multiple items.
// It should be able to add and remove items.
// Discounts:
//
// 10% discount for all shopping baskets over £20
// If the customer has a valid discount card then they get an additional 5% off.
// Extension (hard!) Add the ability to have buy one get one free items.

var assert = require("assert");
var Basket = require("../basket.js");
var Item = require("../item.js");

describe("Item", function(){
  beforeEach(function(){
    item1 = new Item("Bacon", 2.25, true);
    item2 = new Item("Cheese", 3.00, false);
  });
  it("Item has a name", function(){
    assert.strictEqual(item1.name, "Bacon");
  });
  it("Item has a price", function(){
    assert.strictEqual(item1.price, 2.25);
  });
  it("Item is eligible", function(){
    assert.strictEqual(item1.eligible, true);
  });
  it("Item is not eligible", function(){
    assert.strictEqual(item2.eligible, false);
  });
});
