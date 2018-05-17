# WEEK 1
# FUNCTIONS
# def say_hello(name):
#     return "Hello " + name
#
# my_name = "Ed"
# print(say_hello(my_name))

# CONDITIONALS
# def greet(name):
#     if(name == "Ed"):
#         print("Hi, " + name)
#     elif(name == "John"):
#         print("Ohai, John!")
#     else:
#         print("Sorry, I don't recognise you!")
#     print("End of the function")
#
# greet("Jim")
# greet("John")
# greet("Ed")

# LISTS (ARRAYS)
# my_list = ["Spam", "Ham", "Eggs"]
#
# my_list.append("Jam")
# print(my_list)
#
# my_list.remove("Ham")
# print(my_list)
#
# print(my_list.pop())
# print(my_list.pop(0))
# print(my_list)

# tuple (can't be changed)
# my_list = ("Spam", "Ham", "Eggs")
# my_list.append("Jam")
# print(my_list)

# LOOPS
# favourite_foods = ["Pizza", "Doughnuts", "Tofu"]
# # for loop
# for food in favourite_foods:
#     print(food)
# # comprehensions
# numbers = [1,2,3,4,5]
# multiplied_numbers = [number * 2 for number in numbers]
# print(multiplied_numbers)
#
# even_multiplied_numbers = [number * 2 for number in numbers if number % 2 == 0]
# print(even_multiplied_numbers)

# DICTIONARIES (HASHES)
# person = {
#     "name": "Ed",
#     "favourite_foods": ["Pizza", "Bacon"]
# }
#
# print(person)
# print(person["name"])
# print(person.keys())
# print(person.values())
