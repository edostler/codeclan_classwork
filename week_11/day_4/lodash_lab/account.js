const _ = require("lodash");

var Account = function(name, amount, type){
  this.name = name;
  this.amount = amount;
  this.type = type;
}

module.exports = Account;
