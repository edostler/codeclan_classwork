var assert = require('assert')
var Account = require('../account.js')
var Bank = require('../bank.js')

describe("Account", function(){
  beforeEach(function(){
    account1 = new Account("Ed", 100, "Personal");
  });
  it("Has a name", function(){
    assert.strictEqual(account1.name, "Ed");
  });
  it("Has an amount", function(){
    assert.strictEqual(account1.amount, 100);
  });
  it("Has a type", function(){
    assert.strictEqual(account1.type, "Personal");
  });

});
