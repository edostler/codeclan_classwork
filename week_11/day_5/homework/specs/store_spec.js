var assert = require('assert')
var Record = require('../record.js')
var Store = require('../store.js')
var Customer = require('../customer.js')

describe("Store", function(){
  beforeEach(function(){
    store1 = new Store("Ed's", "Glasgow");
    record1 = new Record("Blink-182", "Take Off Your Pants And Jacket", "Punk-Pop", 899);
    record2 = new Record("The Offspring", "Americana", "Punk", 1099);
    record3 = new Record("Brand New", "Deja Entendu", "Emo", 799);
    record4 = new Record("Flogging Molly", "Drunken Lullabies", "Irish-Punk-Folk-Rock", 599);
    record5 = new Record("Sum 41", "Does This Look Infected", "Punk-Pop", 999);
    store1.add(record1);
    store1.add(record2);
    store1.add(record3);
    store1.add(record4);
  });
  it("Has a name", function(){
    assert.strictEqual(store1.name, "Ed's");
  });
  it("Has a title", function(){
    assert.strictEqual(store1.city, "Glasgow");
  });
  it("Has an inventory that starts with 4 records in it", function(){
    assert.deepStrictEqual(store1.inventory, [record1, record2, record3, record4]);
  });
  it("Has a balance that starts at 0", function(){
    assert.strictEqual(store1.balance, 0);
  });
  it("Can add a record to store inventory", function(){
    store1.add(record5)
    assert.deepStrictEqual(store1.inventory, [record1, record2, record3, record4, record5]);
  });
  it("Can remove a record from store inventory", function(){
    store1.remove(record4)
    assert.deepStrictEqual(store1.inventory, [record1, record2, record3]);
  });
  it("Can increase balance by a given value", function(){
    store1.increaseBalance(5000);
    assert.strictEqual(store1.balance, 5000);
  });
  it("Can decrease balance by a given value", function(){
    store1.decreaseBalance(5000);
    assert.strictEqual(store1.balance, -5000);
  });
  it("Can buy a record - not enough balance", function(){
    store1.buy(record5)
    assert.deepStrictEqual(store1.inventory, [record1, record2, record3, record4]);
    assert.strictEqual(store1.balance, 0);
  });
  it("Can buy a record - enough balance", function(){
    store1.balance = 10000;
    store1.buy(record5)
    assert.deepStrictEqual(store1.inventory, [record1, record2, record3, record4, record5]);
    assert.strictEqual(store1.balance, 9001);
  });
  it("Can sell a record", function(){
    store1.sell(record4)
    assert.deepStrictEqual(store1.inventory, [record1, record2, record3]);
    assert.strictEqual(store1.balance, 599);
  });
  it("Calculate value of inventory", function(){
    assert.strictEqual(store1.inventoryValue(), 3396);
  });
  it("Calculate store value that is balance plus inventory value", function(){
    store1.balance = 10000;
    assert.strictEqual(store1.storeValue(), 13396);
  });
  it("Can find records by genre", function(){
    assert.deepStrictEqual(store1.findByGenre("Irish-Punk-Folk-Rock"), [record4]);
  });
});
