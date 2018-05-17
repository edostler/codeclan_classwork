require("minitest/autorun")
require("minitest/rg")

require_relative("../fizzbuzz")

class FizzBuzzTest < MiniTest::Test

  def test_fizz_buzz__1_returns_itself
    result = fizz_buzz(1)
    assert_equal("1", result)
  end

  def test_fizz_buzz__2_returns_itself
    result = fizz_buzz(2)
    assert_equal("2", result)
  end

  def test_fizz_buzz__3_returns_Fizz
    result = fizz_buzz(3)
    assert_equal("Fizz", result)
  end

  def test_fizz_buzz__5_returns_Buzz
    result = fizz_buzz(5)
    assert_equal("Buzz", result)
  end

  def test_fizz_buzz__6_returns_Fizz
    result = fizz_buzz(6)
    assert_equal("Fizz", result)
  end

  def test_fizz_buzz__10_returns_Buzz
    result = fizz_buzz(10)
    assert_equal("Buzz", result)
  end

  def test_fizz_buzz__15_returns_FizzBuzz
    result = fizz_buzz(15)
    assert_equal("FizzBuzz", result)
  end

  def test_fizz_buzz__30_returns_FizzBuzz
    result = fizz_buzz(30)
    assert_equal("FizzBuzz", result)
  end

end
