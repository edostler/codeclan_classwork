chickens = ['Margaret', 'Hetty', 'Henrietta', 'Audrey', 'Mabel']

# ENUMERATION

# #using for loops
# for chicken in chickens
#   p chicken
# end


# # EACH - same as a for loop
# chickens.each {|chicken| p chicken}
#
# #multiple lines -> use do and end
# chickens.each do |chicken|
#   shouting_chicken = chicken.upcase()
#   p shouting_chicken
# end

# # MAP - takes elements and returns them
# name_lengths = []
# for chicken in chickens
#   name_lengths << chicken.length()
# end
# p name_lengths
#
# name_lengths = chickens.map {|chicken| chicken.length()}
# p name_lengths

# # EACH WITH INDEX - takes element and index and returns both
# chickens.each_with_index {|chicken, index| p "#{chicken} is at index #{index}"}
#
# # FIND - finds first in array that matches condition
# p chickens.find {|chicken| chicken[0] == "H"}
#
# # FINDALL - finds all in array that match condition, gives an array back
# # SELECT - alt to FIND ALL, also gives an array back
# p chickens.find_all {|chicken| chicken[0] == "H"}
# p chickens.select {|chicken| chicken[0] == "H"}
#
# # REDUCE - takes multiple variables from an array and combines them
# p chickens.reduce {|list, chicken| list + ", " + chicken}
# # can also be used with numbers (integers or floats)
# numbers = [1,2,3,4,5]
# p numbers.reduce() {|sum, number| sum + number}
# but note that if the first item is not a number you need an initial value also
# drinks = [
#     {name: "Pepsi", quantity: 10, price: 1},
#     {name: "Budweiser", quantity: 10, price: 3}
# ]
# p drinks.inject(0) {|total, drink| total + (drink[:quantity] * drink[:price]) }
