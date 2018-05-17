require("sinatra")
require("sinatra/contrib/all")

#passing in text to return
get "/hi" do
  "Good morning Ed"
end

#passing in ruby to return
get "/roll-die" do
  rand(1..7).to_s()
end

#passing in parameters to return
get "/name/:first/:last" do
  return "Your name is #{params[:first]} #{params[:last]}"
end
#another eg
get "/friends/:number" do
  friends = ["Joey", "Chandler", "Ross", "Phoebe", "Rachael", "Monica"]
  index = params[:number].to_i - 1
  return friends[index]
end
#another eg
get "/square/:num" do
  num = params[:num].to_i
  return "Number squared = #{num * num}"
end


get "/pet/:hello" do
  "Hello pet"
end
#This next one won't work becasue it matches the same structure as the one above, need to change it so that it is distinct
get "/pet/:name" do
  "Hello #{params[:name]}"
end
#e.g.
get "/pet/name/:name" do
  "Hello #{params[:name]}"
end
