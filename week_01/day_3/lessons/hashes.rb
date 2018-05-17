# #hashes are another collection, but each item has a key that allows us to get out additionally attached information about each items
#
# #to create an empty hash
# my_first_hash = Hash.new()
#
# #to create an empty hash
# my_second_hash = {}
#
# #creates a populated hash with keys and their values
# meals = {"breakfast" => "yoghurt", "lunch" => "roll", "dinner" => "steak"}
# #prints whole hash
# p meals
#
# #creates a populated hash with keys and their values
# new_hash = Hash["first key", "first value", "second key", "second value"]
# p new_hash
#
# #prints the value for this key
# p meals["breakfast"]
#
# #keys can be integers, values can be any type
# silly_hash = {1 => "2", 2 => 3, 4 => false}
# p silly_hash[2]
#
# #assigns a new key and value
# meals["supper"] = "toast"
# p meals
#
# #the value for an existing key can be reassigned like so
# meals["supper"] = "tea and toast"
# p meals
#
# #prints an array of the keys
# p meals.keys()
#
# #prints an array of the values
# p meals.values()
#
# #other intereting ones:
# # merge
# # slice
# # delete
# # clear


# #SYMBOLS often used as hashes
#
# #to print a symbol
# p :my_symbol
#
# #won't cocatenate
# # p :my_symbol + :hello
#
# #to create a hash with symbols
# meals = {:breakfast => "yoghurt", :lunch => "roll"}
# p meals
#
# #to create a hash with symbols
# meals = {breakfast: "yoghurt", lunch: "roll"}
# p meals
#
# #to print, still needs colon at front
# p meals[:lunch]


#NESTED HASHES
#creating hash
countries = {
  uk: {
    capital: "London",
    population: 60000000,
    languages: ["English", "Gaelic", "Welsh"]
  },
  germany: {
    capital: "Berlin",
    population: 82670000,
    languages: ["German", "Bavarian", "Dutch", "Turkish"]
  }
}
#printing various parts of the hash
p countries

p countries[:uk]

p countries[:uk][:population]

p countries[:uk].key("London")

population_string = countries[:uk][:population].to_s()
p "Population #{population_string}"

population_string = countries[:germany][:population].to_s()
p "Population #{population_string}"

p countries[:uk][:languages][0]

p countries[:germany][:languages][-1]
p countries[:germany][:languages].last()
