var assert = require('assert')
var Account = require('../account.js')
var Bank = require('../bank.js')

describe("Bank", function(){
  beforeEach(function(){
    bank1 = new Bank();
    account1 = new Account("Ed", 100, "Personal");
    account2 = new Account("Phil", 300, "Business");
    account3 = new Account("Emma", 200, "Personal");
  });
  it("Bank has an array of accounts that starts empty", function(){
    assert.deepStrictEqual(bank1.accounts, []);
  });
  it("Can add an account to accounts", function(){
    bank1.add(account1);
    assert.deepStrictEqual(bank1.accounts, [account1]);
  });
  it("Can find an account by name", function(){
    bank1.add(account1);
    bank1.add(account2);
    bank1.add(account3);
    assert.deepStrictEqual(bank1.findByName("Phil"), account2);
  });
  it("Can find the account with the largest value", function(){
    bank1.add(account1);
    bank1.add(account2);
    bank1.add(account3);
    assert.deepStrictEqual(bank1.findMax(), account2);
  });
  it("Can find the sum value of all accounts", function(){
    bank1.add(account1);
    bank1.add(account2);
    bank1.add(account3);
    assert.deepStrictEqual(bank1.findSum(), 600);
  });
  it("Can find the average value of all accounts", function(){
    bank1.add(account1);
    bank1.add(account2);
    bank1.add(account3);
    assert.deepStrictEqual(bank1.findMean(), 200);
  });
  it("Can find the sum value of an account type", function(){
    bank1.add(account1);
    bank1.add(account2);
    bank1.add(account3);
    assert.deepStrictEqual(bank1.findSumOfType("Personal"), 300);
  });

});
