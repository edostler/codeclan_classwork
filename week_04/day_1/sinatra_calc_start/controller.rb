require("sinatra")
require("sinatra/contrib/all")
require_relative("models/calculator")

# get "/add/:num1/:num2" do
#   num1 = params[:num1].to_f()
#   num2 = params[:num2].to_f()
#   calculator = Calculator.new(num1, num2)
#   return "#{calculator.add()}"
# end
#
# get "/subtract/:num1/:num2" do
#   num1 = params[:num1].to_f()
#   num2 = params[:num2].to_f()
#   calculator = Calculator.new(num1, num2)
#   return "#{calculator.subtract()}"
# end
#
# get "/multiply/:num1/:num2" do
#   num1 = params[:num1].to_f()
#   num2 = params[:num2].to_f()
#   calculator = Calculator.new(num1, num2)
#   return "#{calculator.multiply()}"
# end
#
# get "/divide/:num1/:num2" do
#   num1 = params[:num1].to_f()
#   num2 = params[:num2].to_f()
#   calculator = Calculator.new(num1, num2)
#   return "#{calculator.divide()}"
# end

#now using our result.erb file - this is because HTML can't handle dynamic variables, but is capable of linking with erb (Embedded Ruby)
get "/add/:num1/:num2" do
  num1 = params[:num1].to_f()
  num2 = params[:num2].to_f()
  calculator = Calculator.new(num1, num2)
  @calculation = calculator.add()
  erb(:result)
end

get "/subtract/:num1/:num2" do
  num1 = params[:num1].to_f()
  num2 = params[:num2].to_f()
  calculator = Calculator.new(num1, num2)
  @calculation = calculator.subtract()
  erb(:result)
end

get "/multiply/:num1/:num2" do
  num1 = params[:num1].to_f()
  num2 = params[:num2].to_f()
  calculator = Calculator.new(num1, num2)
  @calculation = calculator.multiply()
  erb(:result)
end

get "/divide/:num1/:num2" do
  num1 = params[:num1].to_f()
  num2 = params[:num2].to_f()
  calculator = Calculator.new(num1, num2)
  @calculation = calculator.divide()
  erb(:result)
end

#the next bit relates to the instuctors.erb file and is just to show that if you are not displaying something you don't need the equals sign for that bit of the ruby logic
get "/instructors" do
  @instructors = ["Alan", "Ally", "John", "Steve"]
  erb(:instructors)
end


get "/" do
  erb(:home)
end

get "/about-us" do
  erb(:about)
end
