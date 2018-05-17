require('minitest/autorun')
require('minitest/rg')

require_relative('../game.rb')
require_relative('../player.rb')
require_relative('../hiddenword.rb')

class GameTest < MiniTest::Test

  def setup
    @player = Player.new('Ed', 6)
    @hiddenword = HiddenWord.new('snowman')
    @game = Game.new(@player,@hiddenword)
  end

  def test_return_guessed_letters
    assert_equal([], @game.guessed_letters)
  end

  def test_count_guessed_letters
    assert_equal(0, @game.count_guessed_letters())
  end

  def test_record_guessed_letter
    guessed_letter = 'o'
    @game.record_guessed_letter(guessed_letter)
    assert_equal(1, @game.count_guessed_letters())
  end

  def test_subtract_life
    @game.subtract_life()
    assert_equal(5, @player.lives())
  end

  def test_reveal_guessed_letters
    guessed_letter = 'o'
    @game.record_guessed_letter(guessed_letter)
    guessed_letters = @game.guessed_letters
    assert_equal("**o****", @hiddenword.reveal_guessed_letters(guessed_letters))
  end

  def test_count_asterisks
    @game.record_guessed_letter('s')
    @game.record_guessed_letter('n')
    @game.record_guessed_letter('z')
    revealed_string = @hiddenword.reveal_guessed_letters(@game.guessed_letters)
    result = @game.count_asterisks(revealed_string)
    assert_equal(4, result)
  end

  def test_player_guesses__correct
    @game.player_guesses('o')
    assert_equal(6, @player.lives)
    assert_equal(1, @game.count_guessed_letters())
    assert_equal('**o****', @hiddenword.reveal_guessed_letters(@game.guessed_letters))
    assert_nil(@game.check_game_status())
  end

  def test_player_guesses__incorrect
    @game.player_guesses('z')
    assert_equal(5, @player.lives)
    assert_equal(1, @game.count_guessed_letters())
    assert_equal('*******', @hiddenword.reveal_guessed_letters(@game.guessed_letters))
    assert_nil(@game.check_game_status())
  end

  def test_check_game_status__won
    @game.player_guesses('s')
    @game.player_guesses('n')
    @game.player_guesses('o')
    @game.player_guesses('w')
    @game.player_guesses('m')
    @game.player_guesses('a')
    revealed_string = @hiddenword.reveal_guessed_letters(@game.guessed_letters)
    result1 = @game.count_asterisks(revealed_string)
    result2 = @game.check_game_status()
    assert_equal(0, result1)
    assert_equal('You win, well done!', result2)
  end

  def test_check_game_status__lost
    @game.player_guesses('q')
    @game.player_guesses('e')
    @game.player_guesses('r')
    @game.player_guesses('t')
    @game.player_guesses('y')
    @game.player_guesses('u')
    result = @game.check_game_status()
    assert_equal(0, @player.lives)
    assert_equal('You lose, game over!',result)
  end

end
