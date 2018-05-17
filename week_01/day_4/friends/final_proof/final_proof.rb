@person1 = {
  name: "Alan",
  age: 12,
  monies: 1,
  friends: ["Steve","John","Kenny", "Ally"],
  favourites: {
    tv_show: "Friends",
    things_to_eat: ["charcuterie"]
  }
}

@person2 = {
  name: "Steve",
  age: 15,
  monies: 2,
  friends: ["John"],
  favourites: {
    tv_show: "Baywatch",
    things_to_eat: ["soup","bread"]
  }
}

@person3 = {
  name: "Ally",
  age: 18,
  monies: 20,
  friends: ["Alan", "Steve"],
  favourites: {
    tv_show: "Pokemon",
    things_to_eat: ["ratatouille", "stew"]
  }
}

@person4 = {
  name: "John",
  age: 18,
  monies: 20,
  friends: ["Alan", "Steve", "Kenny"],
  favourites: {
    tv_show: "Pokemon",
    things_to_eat: ["spaghetti"]
  }
}

@person5 = {
  name: "Kenny",
  age: 20,
  monies: 100,
  friends: [],
  favourites: {
    tv_show: "Scrubs",
    things_to_eat: ["spinach"]
  }
}

@people = [@person1, @person2, @person3, @person4, @person5]

# Optional, VERY TOUGH
# 10. Find the people who have the same favourite tv show
def find_show_buddies(people)

  tv_shows = []
  for person in people
    tv_shows.push(person[:favourites][:tv_show])
    p tv_shows
  end
  p tv_shows

  same_show = []
  count = 0
  for show in tv_shows
    if tv_shows.count(show) > 1
      same_show.push(count)
      p same_show
      p count
    end
    count += 1
  end
  p same_show

  show_buddies = []
  for index in same_show
    show_buddies.push(people[index][:name])
    p show_buddies
  end
  p show_buddies

  return show_buddies
end

find_show_buddies(@people)
