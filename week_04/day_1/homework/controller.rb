require("sinatra")
require("sinatra/contrib/all")
require_relative("models/game")

get "/game/:player1/:player2" do
  player1 = params[:player1]
  player2 = params[:player2]
  game = Game.new(player1, player2)
  @result = game.game_result()
  erb(:result)
end

get "/welcome" do
  erb(:welcome)
end
