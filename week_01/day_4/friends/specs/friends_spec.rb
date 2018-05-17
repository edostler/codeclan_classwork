require( 'minitest/autorun' )
require_relative( '../friends' )

class TestFriends < MiniTest::Test

  def setup

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

  end

  # 1. For a given person, return their name
  def test_getting_name
    result = get_name(@person5)
    assert_equal("Kenny", result)
  end

  # 2. For a given person, return their favourite tv show
  # (e.g. for @person2, function should return the string "Baywatch")
  def test_getting_tv_show
    result = get_tv_show(@person4)
    assert_equal("Pokemon", result)
  end

  # 3. For a given person, check if they like a particular food
  # (e.g. function should return true for @person3 when checked for "stew", false for "spinach")
  def test_food_tastes__true
    result = food_tastes(@person4, "spaghetti")
    assert_equal(true, result)
  end

  def test_food_tastes__false
    result = food_tastes(@person4, "spinach")
    assert_equal(false, result)
  end

  # 4. For a given person, add a new name to their list of friends
  # (hint: Add a new string to the friends array, then test for the length of the array, not the return value of your add_friend method)
  def test_add_friend
    result = add_friend(@person4, "Ed")
    assert_equal(4, result)
  end

  # 5. For a given person, remove a specific name from their list of friends
  # (hint: Same as above, testing for the length of the array should be sufficient)
  def test_remove_friend
    result = remove_friend(@person4, "Alan")
    assert_equal(2, result)
  end

  # 6. Find the total of everyone's money
  # (hint: use the people array)
  def test_total_money
    result = total_money(@people)
    assert_equal(143, result)
  end

  # 7. For two given people, allow the first person to loan a given value of money to the other
  # (hint: you need to pass in the lender, the lendee, and the amount for this function)
  # (hint2: You should test if both the lender's and the lendee's money have changed)
  def test_loan
    result = loan(@person5, @person4, 120)
    assert_equal([-20, 140], result)
  end

  # 8. Find the set of everyone's favourite food joined together
  # (hint: concatenate the favourites/things_to_eat arrays together)
  def test_get_all_food
    result = get_all_food(@people)
    assert_equal(["charcuterie", "soup", "bread", "ratatouille", "stew", "spaghetti", "spinach"], result)
  end

  # 9. Find people with no friends
  # (hint: return an array, there might be more people in the future with no friends!)
  def test_find_people_with_no_friends
    result = find_people_with_no_friends(@people)
    assert_equal(["Kenny"], result)
  end

  # Optional, VERY TOUGH
  # 10. Find the people who have the same favourite tv show
  def test_find_show_buddies
    result = find_show_buddies(@people)
    assert_equal(["Ally", "John"], result)
  end

  def test_find_show_buddies__alt
    result = find_show_buddies__alt(@people)
    assert_equal({ "Pokemon" => ["Ally", "John"] }, result)
  end
end
