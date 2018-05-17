require("minitest/autorun")
require_relative("../my_functions")

class FunctionsTest < MiniTest::Test
  def test_greet()
    # arrange

    # act
    result = greet("Ed", "morning")

    # assert
    assert_equal("Good morning, Ed", result)
  end
  
  def test_greet__evening()
    # arrange

    # act
    result = greet("Sarah", "evening")

    # assert
    assert_equal("Good evening, Sarah", result)
  end
end
