var WaterBottle = function(){
  this.volume = 0;
}

WaterBottle.prototype.fill = function () {
    this.volume = 100;
};

WaterBottle.prototype.drink = function (volume) {
  if (this.volume >= volume){
    this.volume -= volume;
  }
  else {
    this.volume -= this.volume;
  }
};

WaterBottle.prototype.empty = function () {
  this.volume = 0;
};

module.exports = WaterBottle;
