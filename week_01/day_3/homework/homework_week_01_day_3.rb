p "Assumption: answers given cumulatively, as opposed to taking the initial array each time."

puts ""
p "EXERCISE A"
stops = [ "Croy", "Cumbernauld", "Falkirk High", "Linlithgow", "Livingston", "Haymarket" ]

puts ""
p "QUESTION 1"
stops.push("Edinburgh Waverley")
#stops << "Edinburgh Waverley"
#stops.insert(-1,"Edinburgh Waverley")
p stops

puts ""
p "QUESTION 2"
stops.insert(0,"Glasgow Queen St")
#stops.unshift("Glasgow Queen St")
p stops

puts ""
p "QUESTION 3"
stops.insert(4,"Polmont")
p stops

puts ""
p "QUESTION 4"
counter = 0
for stop in stops
  if stop == "Linlithgow"
    index = counter
  else
    counter += 1
  end
end
p "Linlithgow has index #{index}"
#stops.index("Linlithgow")
#stops.find_index("Linlithgow")

puts ""
p "QUESTION 5"
stops.delete("Livingston")
p stops

puts ""
p "QUESTION 6"
counter = 0
for stop in stops
  if stop == "Cumbernauld"
    stops.delete_at(counter)
  else
    counter += 1
  end
end
p stops
#stops.delete_at(2)

puts ""
p "QUESTION 7"
p "There are #{stops.length()} stops in the array"

puts ""
p "QUESTION 8"
p stops[2]
p stops[-5]
p stops.at(2)
p stops.fetch(2)
p stops.drop(2).take(1)
p "I'll give you 5 - I think there are probably loads more :)"

puts ""
p "QUESTION 9"
p stops.reverse!()

puts ""
p "QUESTION 10"
for stop in stops
  p stop
end

puts ""
p "EXERCISE B"
users = {
  "Jonathan" => {
    :twitter => "jonnyt",
    :favourite_numbers => [12, 42, 75, 12, 5],
    :home_town => "Stirling",
    :pets => {
      "fluffy" => :cat,
      "fido" => :dog,
      "spike" => :dog
    }
  },
  "Erik" => {
    :twitter => "eriksf",
    :favourite_numbers => [8, 12, 24],
    :home_town => "Linlithgow",
    :pets => {
      "nemo" => :fish,
      "kevin" => :fish,
      "spike" => :dog,
      "rupert" => :parrot
    }
  },
  "Avril" => {
    :twitter => "bridgpally",
    :favourite_numbers => [12, 14, 85, 88],
    :home_town => "Dunbar",
    :pets => {
      "colin" => :snake
    }
  },
}

puts ""
p "QUESTION 1"
p users["Jonathan"][:twitter]

puts ""
p "QUESTION 2"
p users["Erik"][:home_town]

puts ""
p "QUESTION 3"
p users["Erik"][:favourite_numbers]

puts ""
p "QUESTION 4"
p users["Avril"][:pets]["colin"]

puts ""
p "QUESTION 5"
p users["Erik"][:favourite_numbers].min()
# p users["Erik"][:favourite_numbers].sort()[0]
# p users["Erik"][:favourite_numbers].sort().first()

puts ""
p "QUESTION 6"
users["Erik"][:favourite_numbers].push(7)
# users["Erik"][:favourite_numbers] << 7
p users["Erik"][:favourite_numbers]

puts ""
p "QUESTION 7"
users["Erik"][:home_town] = "Edinburgh"
p users["Erik"][:home_town]

puts ""
p "QUESTION 8"
users["Erik"][:pets]["fluffy"] = :dog
# users["Erik"][:pets].store("fluffy", :dog)
p users["Erik"]

puts ""
p "QUESTION 9"
my_hash = {
  "Ed" => {
    :twitter => "edo",
    :favourite_numbers => [2, 7, 11, 27, 31],
    :home_town => "Wisbech",
    :pets => {
      "blinky" => :dog,
      "twizzle" => :cat
    }
  }
}
users.merge!(my_hash)
# users["Ed"] => {
#   :twitter => "edo",
#   :favourite_numbers => [2, 7, 11, 27, 31],
#   :home_town => "Wisbech",
#   :pets => {
#     "blinky" => :dog,
#     "twizzle" => :cat
#   }
# }
p users

puts ""
p "EXERCISE C"
united_kingdom = [
  {
    name: "Scotland",
    population: 5295000,
    capital: "Edinburgh"
  }, {
    name: "Wales",
    population: 3063000,
    capital: "Swansea"
  }, {
    name: "England",
    population: 53010000,
    capital: "London"
  }
]

puts ""
p "QUESTION 1"
united_kingdom[1][:capital] = "Cardiff"
p united_kingdom

puts ""
p "QUESTION 2"
northern_ireland = { :name => "Northern Ireland", :population => 1811000, :capital => "Belfast" }
united_kingdom.insert(3, northern_ireland)

# northern_ireland = { :name => "Northern Ireland", :population => 1811000, :capital => "Belfast" }
# united_kingdom << northern_ireland
#
# united_kingdom << {
#   name: "Northern Ireland",
#   population: 1811000,
#   capital: Belfast
# }

p united_kingdom

puts ""
p "QUESTION 3"
for countries in united_kingdom
  p countries[:name]
end

puts ""
p "QUESTION 4"
total = 0
for countries in united_kingdom
  total += countries[:population]
end
p total
