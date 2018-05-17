# 1. For a given person, return their name
def get_name(person)
  return person[:name]
end

# 2. For a given person, return their favourite tv show
# (e.g. for @person2, function should return the string "Baywatch")
def get_tv_show(person)
  return person[:favourites][:tv_show]
end

# 3. For a given person, check if they like a particular food
# (e.g. function should return true for @person3 when checked for "stew", false for "spinach")
def food_tastes(person, food)
  return person[:favourites][:things_to_eat].include?(food)
end


# 4. For a given person, add a new name to their list of friends
# (hint: Add a new string to the friends array, then test for the length of the array, not the return value of your add_friend method)
def add_friend(person, friend_to_add)
  person[:friends] << friend_to_add
  return person[:friends].length()
end

# 5. For a given person, remove a specific name from their list of friends
# (hint: Same as above, testing for the length of the array should be sufficient)
def remove_friend(person, friend_to_remove)
  person[:friends].delete(friend_to_remove)
  return person[:friends].length()
end

# 6. Find the total of everyone's money
# (hint: use the people array)
def total_money(people)
  total = 0
  for person in people
    total += person[:monies]
  end
  return total
end

# 7. For two given people, allow the first person to loan a given value of money to the other
# (hint: you need to pass in the lender, the lendee, and the amount for this function)
# (hint2: You should test if both the lender's and the lendee's money have changed)
def loan(lender, lendee, amount)
  lender[:monies] -= amount
  lendee[:monies] += amount
  return [lender[:monies], lendee[:monies]]
end

# 8. Find the set of everyone's favourite food joined together
# (hint: concatenate the favourites/things_to_eat arrays together)
def get_all_food(people)
  food_array = []
  for person in people
    food_array += person[:favourites][:things_to_eat]
  end
  return food_array
end

# 9. Find people with no friends
# (hint: return an array, there might be more people in the future with no friends!)
def find_people_with_no_friends(people)
  no_friends_array = []
  for person in people
    if person[:friends].length() == 0
      no_friends_array << person[:name]
    end
  end
  return no_friends_array
end

# Optional, VERY TOUGH
# 10. Find the people who have the same favourite tv show
def find_show_buddies(people)

  tv_shows = []

  for person in people
    tv_shows.push(person[:favourites][:tv_show])
  end

  same_show = []
  count = 0

  for show in tv_shows
    if tv_shows.count(show) > 1
      same_show.push(count)
    end
    count += 1
  end

  show_buddies = []

  for index in same_show
    show_buddies.push(people[index][:name])
  end

  return show_buddies
end

def find_show_buddies__alt(people)
  tv_shows = {}
  same_tv_shows = {}
  for person in people
    show = person[:favourites][:tv_show]
    if tv_shows[show] != nil
      tv_shows[show] << person[:name]
    else
      tv_shows[show] = [person[:name]]
    end
  end
  for name in tv_shows.keys
    if tv_shows[name].length > 1
      same_tv_shows[name] = tv_shows[name]
    end
  end
  return same_tv_shows
end
