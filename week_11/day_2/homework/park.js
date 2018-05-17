var Park = function(){
  this.enclosure = [];
}

Park.prototype.add = function (dino) {
  this.enclosure.push(dino);
};

Park.prototype.remove = function (type) {
  for (i=0; i < this.enclosure.length; i++) {
    if (this.enclosure[i].type === type) {
      this.enclosure.splice(i, 1);
      i -= 1;
    }
  }
};

Park.prototype.breeders = function (annualOffspring) {
  let breeders = [];
  for (dino of this.enclosure) {
    if (dino.annualOffspring > annualOffspring) {
      breeders.push(dino);
    }
  }
  return breeders;
};

Park.prototype.calculate = function (enclosure) {
  let endOfYearPopulation = [];
  for (dino of enclosure) {
    endOfYearPopulation.push(dino);
    for (i = 0; i < dino.annualOffspring; i++){
      endOfYearPopulation.push(dino);
    }
  }
  return endOfYearPopulation;
};

module.exports = Park;
