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

describe("Basket", function(){
  beforeEach(function(){
    basket1 = new Basket(false);
    basket2 = new Basket(true);
    item1 = new Item("Bacon", 225, true);
    item2 = new Item("Cheese", 300, false);
    item3 = new Item("Expensive Bread", 500, false);
    item4 = new Item("Bacon", 225, true);
    item5 = new Item("Bacon", 225, true);
    item6 = new Item("Cheese", 300, false);
  });
  it("Basket starts empty", function(){
    assert.strictEqual(basket1.contents.length, 0);
  });
  it("Basket starts empty with deepStrictEqual", function(){
    assert.deepStrictEqual(basket1.contents, []);
  });
  it("Can add item to basket", function(){
    basket1.add(item1);
    assert.strictEqual(basket1.contents.length, 1);
  });
  it("Can add item to basket with deepStrictEqual", function(){
    basket1.add(item1);
    assert.deepStrictEqual(basket1.contents, [item1]);
  });
  it("Can remove item from basket", function(){
    basket1.add(item1);
    basket1.add(item2);
    basket1.add(item3);
    basket1.remove(item2);
    assert.strictEqual(basket1.contents.length, 2);
  });
  // it("Can remove item from basket with deepStrictEqual", function(){
  //   basket1.add(item1);
  //   basket1.add(item2);
  //   basket1.add(item3);
  //   basket1.remove(item2);
  //   assert.strictEqual(basket1.contents, [item1, item3]);
  // });
  it("Can get total of basket", function(){
    basket1.add(item1);
    basket1.add(item2);
    basket1.add(item3);
    assert.strictEqual(basket1.total(), 1025);
  });
  it("Apply 10% discount if total over £20, rounding up to the nearest pence if necessary", function(){
    basket1.add(item1);
    basket1.add(item2);
    basket1.add(item3);
    basket1.add(item3);
    basket1.add(item3);
    assert.strictEqual(basket1.total(), 1823);
  });
  it("Apply 5% discount if customer basket has a discount card", function(){
    basket2.add(item1);
    basket2.add(item2);
    basket2.add(item3);
    assert.strictEqual(basket2.total(), 974);
  });
  it("Apply 15% discount if customer basket has a discount card and total over £20", function(){
    basket2.add(item1);
    basket2.add(item2);
    basket2.add(item3);
    basket2.add(item3);
    basket2.add(item3);
    assert.strictEqual(basket2.total(), 1722);
  });
  it("Buy one get one free on any eligible products", function(){
    basket1.add(item1);
    basket1.add(item2);
    basket1.add(item3);
    basket1.add(item4);
    basket1.add(item5);
    basket1.add(item6);
    assert.strictEqual(basket1.total(), 1550);
  });
});
