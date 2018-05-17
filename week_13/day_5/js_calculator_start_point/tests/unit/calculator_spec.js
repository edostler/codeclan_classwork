var Calculator = require('../../public/js/calculator.js')
var assert = require('assert')

describe('calculator', function () {
  beforeEach(function () {
    calculator = new Calculator()
  });

  // write unit tests here in the form of "it should do something..."
  it('it has a sample test', function(){
    assert.equal(true, true)
  })

  it('can add', function(){
    calculator.clearClick();
    calculator.numberClick(2);
    calculator.numberClick(0);
    calculator.operatorClick("+");
    calculator.numberClick(5);
    calculator.operatorClick("=");
    assert.equal(25, calculator.runningTotal);
  })

  it('can subtract', function(){
    calculator.clearClick();
    calculator.numberClick(8);
    calculator.numberClick(3);
    calculator.operatorClick("-");
    calculator.numberClick(3);
    calculator.operatorClick("=");
    assert.equal(80, calculator.runningTotal)
  })

  it('can multiply', function(){
    calculator.clearClick();
    calculator.numberClick(8);
    calculator.numberClick(3);
    calculator.operatorClick("*");
    calculator.numberClick(2);
    calculator.operatorClick("=");
    assert.equal(166, calculator.runningTotal)
  })

  it('can divide - by 0 gives "Err"', function(){
    calculator.clearClick();
    calculator.numberClick(8);
    calculator.numberClick(0);
    calculator.operatorClick("/");
    calculator.numberClick(0);
    calculator.operatorClick("=");
    assert.equal("Err", calculator.runningTotal)
  })

  it('can divide', function(){
    calculator.clearClick();
    calculator.numberClick(8);
    calculator.numberClick(0);
    calculator.operatorClick("/");
    calculator.numberClick(2);
    calculator.operatorClick("=");
    assert.equal(40, calculator.runningTotal)
  })

  it('can click number', function(){
    calculator.clearClick();
    calculator.numberClick(1);
    calculator.numberClick(2);
    calculator.numberClick(3);
    calculator.numberClick(4);
    calculator.numberClick(5);
    calculator.numberClick(6);
    calculator.numberClick(7);
    calculator.numberClick(8);
    calculator.numberClick(9);
    calculator.numberClick(0);
    assert.equal(1234567890, calculator.runningTotal)
  })

  it('can click operator', function(){
    calculator.clearClick();
    calculator.operatorClick("+");
    assert.equal("+", calculator.previousOperator)
    calculator.operatorClick("-");
    assert.equal("-", calculator.previousOperator)
    calculator.operatorClick("*");
    assert.equal("*", calculator.previousOperator)
    calculator.operatorClick("/");
    assert.equal("/", calculator.previousOperator)
    calculator.operatorClick("=");
    assert.equal(null, calculator.previousOperator)
  })

  it('can click clear', function(){
    calculator.previousTotal = 20;
    calculator.runningTotal = 0;
    calculator.previousOperator = "+";
    assert.equal("+", calculator.previousOperator)
    assert.equal(0, calculator.runningTotal)
    assert.equal(20, calculator.previousTotal)
    calculator.clearClick();
    assert.equal(null, calculator.previousOperator)
    assert.equal(0, calculator.runningTotal)
    assert.equal(null, calculator.previousTotal)
  })

});
