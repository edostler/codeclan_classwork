var Enumeration = function() {}

Enumeration.prototype.find = function(array, callback) {
  for (element of array) {
    if (callback(element)){
      return element;
    }
  }
}

Enumeration.prototype.map = function (array, callback) {
  const newArray = [];
  for (element of array) {
    newArray.push(callback(element));
  }
  return newArray;
};

Enumeration.prototype.filter = function (array, callback) {
  const newArray = [];
  for (element of array) {
    if (callback(element)){
      newArray.push(element);
    }
  }
  return newArray;
};

Enumeration.prototype.some = function (array, callback) {
  for (element of array) {
    if (callback(element)){
      return true;
    }
  }
  return false;
};

Enumeration.prototype.every = function (array, callback) {
  for (element of array) {
    if (!callback(element)){
      return false;
    }
  }
  return true;
};

Enumeration.prototype.reduce = function (array, callback) {
  let total = 0;
  for (element of array) {
    total = callback(total, element);
  }
  return total;
};

module.exports = Enumeration;
