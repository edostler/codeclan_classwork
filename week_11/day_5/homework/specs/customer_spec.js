var assert = require('assert')
var Record = require('../record.js')
var Store = require('../store.js')
var Customer = require('../customer.js')

describe("Customer", function(){
  beforeEach(function(){
    customer1 = new Customer("Ed", 3500);
    customer2 = new Customer("Phil", 3500);
    record1 = new Record("Blink-182", "Take Off Your Pants And Jacket", "Punk-Pop", 899);
    record2 = new Record("The Offspring", "Americana", "Punk", 1099);
    record3 = new Record("Brand New", "Deja Entendu", "Emo", 799);
  });
  it("Has a name", function(){
    assert.strictEqual(customer1.name, "Ed");
  });
  it("Has cash", function(){
    assert.strictEqual(customer1.cash, 3500);
  });
  it("Has a recordCollection that starts empty", function(){
    assert.deepStrictEqual(customer1.recordCollection, []);
  });
  it("Can add a record to customers record collection", function(){
    customer1.add(record1)
    assert.deepStrictEqual(customer1.recordCollection, [record1]);
  });
  it("Can remove a record from customer record collection", function(){
    customer1.add(record1)
    customer1.add(record2)
    customer1.add(record3)
    customer1.remove(record1)
    assert.deepStrictEqual(customer1.recordCollection, [record2, record3]);
  });
  it("Can increase cash by a given value", function(){
    customer1.increaseCash(5000);
    assert.strictEqual(customer1.cash, 8500);
  });
  it("Can decrease cash by a given value", function(){
    customer1.decreaseCash(5000);
    assert.strictEqual(customer1.cash, -1500);
  });
  it("Can buy a record - enough cash", function(){
    customer1.buy(record1)
    assert.deepStrictEqual(customer1.recordCollection, [record1]);
    assert.strictEqual(customer1.cash, 2601);
  });
  it("Can buy a record - not enough cash", function(){
    customer1.cash = 0;
    customer1.buy(record1)
    assert.deepStrictEqual(customer1.recordCollection, []);
    assert.strictEqual(customer1.cash, 0);
  });
  it("Can sell a record", function(){
    customer1.add(record1)
    customer1.sell(record1)
    assert.deepStrictEqual(customer1.recordCollection, []);
    assert.strictEqual(customer1.cash, 4399);
  });
  it("Calculate value of record collection", function(){
    customer1.add(record1)
    assert.strictEqual(customer1.collectionValue(), 899);
  });
  it("Calculate customer value that is cash plus record collection value", function(){
    customer1.add(record1)
    assert.strictEqual(customer1.customerValue(), 4399);
  });
  it("Calculate value of record collection by genre", function(){
    customer1.add(record1)
    customer1.add(record2)
    assert.strictEqual(customer1.genreValue("Punk-Pop"), 899);
  });
  it("Find most valuable record", function(){
    customer1.add(record1)
    customer1.add(record2)
    assert.strictEqual(customer1.findMostValuable(), record2);
  });
  it("Can sort record collection by value ascending or descending - ascending", function(){
    customer1.add(record1)
    customer1.add(record2)
    customer1.add(record3)
    assert.deepStrictEqual(customer1.orderByValue("asc"), [record3, record1, record2]);
  });
  it("Can sort record collection by value ascending or descending - descending", function(){
    customer1.add(record1)
    customer1.add(record2)
    customer1.add(record3)
    assert.deepStrictEqual(customer1.orderByValue("desc"), [record2, record1, record3]);
  });
  it("Compare value of record collection to other record collection", function(){
    customer1.add(record1)
    customer1.add(record2)
    customer2.add(record3)
    assert.strictEqual(customer1.compareCollectionValue(customer2), 1199);
  });
});
