const _ = require("lodash");

var Customer = function(name, cash){
  this.name = name;
  this.cash = cash;
  this.recordCollection = [];
}

Customer.prototype.add = function (record) {
  this.recordCollection.push(record);
};

Customer.prototype.remove = function (recordToRemove) {
  let newRecordCollection = _.remove(this.recordCollection, function(record) {
  return record !== recordToRemove;
  });
  this.recordCollection = newRecordCollection;
};

Customer.prototype.increaseCash = function (value) {
  this.cash += value;
};

Customer.prototype.decreaseCash = function (value) {
  this.cash -= value;
};

Customer.prototype.buy = function (record) {
  if (this.cash >= record.price) {
    this.decreaseCash(record.price);
    this.add(record);
  }
};

Customer.prototype.sell = function (record) {
  this.increaseCash(record.price);
  this.remove(record);
};

Customer.prototype.collectionValue = function () {
  return _.sumBy(this.recordCollection, "price");
};

Customer.prototype.customerValue = function () {
  return this.cash + this.collectionValue();
};

Customer.prototype.genreValue = function (genre) {
  let filtered = _.filter(this.recordCollection, record => record.genre === genre)
  return _.sumBy(filtered, "price");
};

Customer.prototype.findMostValuable = function () {
  return _.maxBy(this.recordCollection, "price");
};

Customer.prototype.orderByValue = function (order) {
  return _.orderBy(this.recordCollection, 'price', order);
};

Customer.prototype.compareCollectionValue = function (customer) {
  return this.collectionValue() - customer.collectionValue();
};

module.exports = Customer;
