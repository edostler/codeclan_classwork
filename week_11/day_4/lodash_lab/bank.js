const _ = require("lodash");

var Bank = function(){
  this.accounts = [];
}

Bank.prototype.add = function (account) {
  this.accounts.push(account);
};

Bank.prototype.findByName = function (nameToFind) {
  return _.find(this.accounts, {name: nameToFind});
};

Bank.prototype.findMax = function () {
  return _.maxBy(this.accounts, "amount");
};

Bank.prototype.findSum = function () {
  return _.sumBy(this.accounts, "amount");
};

Bank.prototype.findMean = function () {
  return _.meanBy(this.accounts, "amount");
};

Bank.prototype.findSumOfType = function (type) {
  let filtered = _.filter(this.accounts, account => account.type === type)
  return _.sumBy(filtered, "amount");
};

module.exports = Bank;
