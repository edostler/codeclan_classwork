
require('minitest/autorun')
require('minitest/rg')
require_relative('../fish.rb')
require_relative('../river.rb')

class RiverTest < MiniTest::Test

  def setup
    @fish = Fish.new('Fingers')
    @river = River.new('Amazon')
  end

  def test_count_fish
    assert_equal(0, @river.count_fish())
  end

  def test_add_fish
    @river.add_fish(@fish)
    assert_equal(1, @river.count_fish())
  end

  def test_remove_fish
    @river.add_fish(@fish)
    fish = @river.remove_fish()
    assert_equal(0, @river.count_fish())
    assert_equal('Fingers', fish)
  end

end
