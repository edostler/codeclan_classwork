class Game

  attr_reader :guessed_letters

  def initialize(player,hiddenword)
    @player = player
    @hiddenword = hiddenword
    @guessed_letters = []
  end

  def count_guessed_letters
    @guessed_letters.uniq().count()
  end

  def record_guessed_letter(letter)
    @guessed_letters << letter
  end

  def subtract_life
    @player.lives -= 1
  end

  def count_asterisks(revealed_string)
    return revealed_string.count('*')
  end

  def player_guesses(letter)
    record_guessed_letter(letter)
    if @hiddenword.check_guessed_letter(letter)
      return @hiddenword.reveal_guessed_letters(@guessed_letters)
    else
      subtract_life()
    end
  end

  def check_game_status
    revealed_string = @hiddenword.reveal_guessed_letters(@guessed_letters)
    if count_asterisks(revealed_string) == 0
      return 'You win, well done!'
    elsif @player.lives == 0
      return 'You lose, game over!'
    end
  end

end
