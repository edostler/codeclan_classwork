require('minitest/autorun')
require('minitest/rg')

require_relative('../player.rb')

class PlayerTest < MiniTest::Test

  def setup
    @player = Player.new('Ed', 6)
  end

  def test_player_has_name
    assert_equal('Ed', @player.name)
  end

  def test_player_has_lives
    assert_equal(6, @player.lives)
  end

end
