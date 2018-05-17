require 'minitest/autorun'
require_relative '../models/game'

class TestGame < Minitest::Test

  def setup
    @game1 = Game.new("Rock", "Scissors")
    @game2 = Game.new("Rock", "Paper")
    @game3 = Game.new("Rock", "Rock")
  end

  def test_game_result__player_1_wins
    assert_equal("Player 1 Wins with Rock!", @game1.game_result())
  end

  def test_game_result__player_2_wins
    assert_equal("Player 2 Wins with Paper!", @game2.game_result())
  end

  def test_game_result__draw
    assert_equal("It's A Draw!", @game3.game_result())
  end

end
