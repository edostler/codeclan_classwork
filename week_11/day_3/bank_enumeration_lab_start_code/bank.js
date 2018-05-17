var Bank = function() {
  this.accounts = [];
}

Bank.prototype.addAccount = function (account) {
  this.accounts.push(account);
}

Bank.prototype.accountByName = function (name) {
  const found = this.accounts.find(function(account){
    return account.name === name;
  });
  return found;
};

// DANNY's SOLUTION
// Bank.prototype.largestAccount = function (account) {
// let found = this.accounts[0];
// this.accounts.forEach(function(account){
//   if(account.value > found.value){
//     found = account;
//   }
// });
// return found;
// };

Bank.prototype.largestAccount = function () {
  let currentMax = 0;
  this.accounts.forEach(function(account){
    if (account.value > currentMax){
      currentMax = account.value;
    }
    return currentMax;
  });
  const found = this.accounts.find(function(account){
    return account.value === currentMax;
  });
  return found;
};

Bank.prototype.payInterest = function () {
  this.accounts.forEach(function(account){
    account.value = account.value * 1.1;

  // this.accounts.map(function(account){
  //   account.value = account.value * 1.1;
  //   return account;
  });
};

Bank.prototype.businessAccounts = function () {
  const businessAccounts = this.accounts.filter(function(account){
    return account.type === "business";
  });
  return businessAccounts;
};

Bank.prototype.totalValue = function () {
  let total = 0;
  this.accounts.forEach(function(account){
    total += account.value;
  });
  return total;

  // SEE JOHN's SOLUTION FOR REDUCE
  // this.accounts.reduce(function(runningTotal, account){
  //   return runningTotal + account.value;
  // });
  // return total;
};

Bank.prototype.averageValue = function () {
  let total = this.totalValue();
  let numberOfAccounts = this.accounts.length;
  let average = total/numberOfAccounts;
  return average;
};

module.exports = Bank;
