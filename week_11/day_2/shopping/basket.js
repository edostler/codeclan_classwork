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

var Basket = function(discount){
  this.discount = discount;
  this.contents = [];
}

Basket.prototype.add = function (item) {
  if (item.eligible) {
    let currentQuanity = 0;
    for (currentItem of this.contents) {
      if (currentItem.name === item.name) {
        currentQuanity += 1;
      }
    }
    if ((currentQuanity + 1) % 2 === 0){
      item.price = 0;
    }
  }
  this.contents.push(item);
};

Basket.prototype.remove = function (item) {
  const index = this.contents.indexOf(item);
  this.contents.splice(index, 1);
};

Basket.prototype.total = function () {
  let total = 0;
  let discount = 0;
  for (item of this.contents) {
    total += item.price;
  }
  if (total >= 2000){
    discount += 0.1;
  }
  if (this.discount){
    discount += 0.05;
  }
  total = total * (1 - discount);
  return Math.ceil(total);
};

module.exports = Basket;
