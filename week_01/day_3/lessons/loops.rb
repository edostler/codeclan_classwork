#WHILE LOOP COUNTER
counter = 0
my_number = 5

while (counter < my_number)
  p "Counter is #{counter}"
  counter += 1
end
p "The loop has ended"

#WHILE LOOP MATCH VALUE
my_number = 5
p "What number am I thinking of?"
value = gets.to_i()

while (value != my_number)
  p "Nope, try again!"
  value = gets.to_i()
end
p "Well done!"

#WHILE LOOP BREAKING (ctrl+c in terminal otherwise)
while (true)
  p "Type something"
  line = gets.chomp()
  break if (line.downcase == "q")
  p "You entered: #{line}"
end

#LOOPING THROUGH AN ARRAY
numbers = [1,2,3,4,5]

for num in numbers
  p num * 3
end

#SUMMING AN ARRAY
numbers = [1,2,3,4,5]
total = 0
for num in numbers
  total = total + num
end
p total

#LOOPING AN ARRAY OF hashes
chicken_hashes = [
  { name: "Margaret", age: 2, eggs: 0},
  { name: "Hetty", age: 1, eggs: 2},
  { name: "Henrietta", age: 3, eggs: 1},
  { name: "Audrey", age: 2, eggs: 0}
]
for chicken in chicken_hashes
  p chicken[:name]
  if chicken[:eggs] > 0
    p "Whoops, eggs!"
  end
end
#or alternatively:
chicken_hashes = [
  { name: "Margaret", age: 2, eggs: 0},
  { name: "Hetty", age: 1, eggs: 2},
  { name: "Henrietta", age: 3, eggs: 1},
  { name: "Audrey", age: 2, eggs: 0}
]
for chicken in chicken_hashes
  eggs = ""
  if chicken[:eggs] > 0
    eggs = " - Whoops, eggs!"
  end
  p chicken[:name] + eggs
end

calculating with loops and hashes
def count_eggs(chicken_array)
  total_eggs = 0
  for chicken in chicken_array
    total_eggs += chicken[:eggs]
  end
  return total_eggs
end

p count_eggs(chicken_hashes)

#another example - note that becasue of TDD we have to use return in the function, not a print etc.
def find_chicken_by_name(chicken_array, name)
  for chicken in chicken_array
    if chicken[:name] == name
      return chicken
    end
  end
  return nil
end

result = find_chicken_by_name(chicken_hashes, "Audrey")

if (result != nil)
  p result[:name]
else
  p "Not found"
end
