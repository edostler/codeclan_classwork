
require('minitest/autorun')
require('minitest/rg')
require_relative('../bear.rb')
require_relative('../fish.rb')
require_relative('../river.rb')

class BearTest < MiniTest::Test

  def setup
    @bear = Bear.new('Yogi')
    @fish = Fish.new('Fingers')
    @river = River.new('Amazon')
  end

  def test_count_stomach_contents
    assert_equal(0, @bear.stomach_contents())
  end

  def test_can_eat_fish
    @river.add_fish(@fish)
    @bear.catch_fish(@fish)
    assert_equal(1, @bear.stomach_contents())
  end

  def test_can_eat_fish_from_river
    @river.add_fish(@fish)
    @bear.catch_fish(@river.remove_fish)
    assert_equal(1, @bear.stomach_contents())
  end

  def test_can_eat_fish_from_river
    @bear.catch_fish(@river.remove_fish)
    assert_equal(0, @bear.stomach_contents())
  end

  def test_roar
    assert_equal('Roaaaar!', @bear.roar())
  end

end
