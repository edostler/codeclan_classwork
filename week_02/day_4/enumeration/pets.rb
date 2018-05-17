pets = [
{
    name: "Sir Percy",
    pet_type: :cat,
    breed: "British Shorthair",
    price: 500
},
{
    name: "King Bagdemagus",
    pet_type: :cat,
    breed: "British Shorthair",
    price: 500
},
{
    name: "Sir Lancelot",
    pet_type: :dog,
    breed: "Pomsky",
    price: 1000,
},
{
    name: "Arthur",
    pet_type: :dog,
    breed: "Husky",
    price: 900,
},
{
    name: "Tristan",
    pet_type: :dog,
    breed: "Basset Hound",
    price: 800,
},
{
    name: "Merlin",
    pet_type: :cat,
    breed: "Egyptian Mau",
    price: 1500,
}
]

# Print out all of the names using a loop

for pet in pets
  p pet[:name]
end
puts ""

# Print out all of the names using an enumerable

pets.each {|pet| p pet[:name]}
puts ""

# Find a pet using a loop and if statement

for pet in pets
  if pet[:name] == 'Tristan'
    p pet
  end
end
puts ""

# Find a pet using an enumerable

p pets.find {|pet| pet[:name] == 'Tristan'}
puts ""

## Task: using enumerable methods:
## 1. Find the pet which breed is Husky
p pets.find {|pet| pet[:breed] == 'Husky'}
puts ""

## 2. Make an array of all of the pets' names
p pet_names = pets.map {|pet| pet[:name]}
puts ""

## 3. Find out if there are any pets of breed 'Dalmation' (true or false)
p pets.any? {|pet| pet[:breed] == 'Dalmation'}
puts ""

## 4. Find the most expensive pet i.e. pet with the highest/maximum price
p pets.max {|pet| pet[:price]}
puts ""

## 5. Find the total value (price) of all of the pets added together.
p pets.reduce(0) {|sum, pet| sum + pet[:price]}
puts ""

## 6. Change each pet so their price is 50% cheaper
p pets.each {|pet| pet[:price] = (pet[:price]/2.0)}
