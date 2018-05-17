# ORDER - logic class and tests in sync, then controller, then web pages (erb files) then layout then CSS

class Game

  def initialize(player1_choice, player2_choice)
    @player1_choice = player1_choice
    @player2_choice = player2_choice
  end

  def game_result()
    if @player1_choice == @player2_choice
      return "It's A Draw!"
    elsif (@player1_choice == "Rock" && @player2_choice == "Scissors") || (@player1_choice == "Scissors" && @player2_choice == "Paper") || (@player1_choice == "Paper" && @player2_choice == "Rock")
      return "Player 1 Wins with #{@player1_choice}!"
    else
      return "Player 2 Wins with #{@player2_choice}!"
    end
  end

end
