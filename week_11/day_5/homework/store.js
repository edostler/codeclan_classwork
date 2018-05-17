const _ = require("lodash");

var Store = function(name, city){
  this.name = name;
  this.city = city;
  this.inventory = [];
  this.balance = 0;
}

Store.prototype.add = function (record) {
  this.inventory.push(record);
};

Store.prototype.remove = function (recordToRemove) {
  let newInventory = _.remove(this.inventory, function(record) {
  return record !== recordToRemove;
  });
  this.inventory = newInventory;
};

Store.prototype.increaseBalance = function (value) {
  this.balance += value;
};

Store.prototype.decreaseBalance = function (value) {
  this.balance -= value;
};

Store.prototype.buy = function (record) {
  if (this.balance >= record.price) {
    this.decreaseBalance(record.price);
    this.add(record);
  }
};

Store.prototype.sell = function (record) {
  this.increaseBalance(record.price);
  this.remove(record);
};

Store.prototype.inventoryValue = function () {
  return _.sumBy(this.inventory, "price");
};

Store.prototype.storeValue = function () {
  return this.balance + this.inventoryValue();
};

Store.prototype.findByGenre = function (genre) {
  return _.filter(this.inventory, record => record.genre === genre);
};

module.exports = Store;
