require "minitest/autorun"
require "minitest/rg"

require_relative "../mob"

class TddPractice < MiniTest::Test
  # Task 1: Pig Latin
  # Pig Latin is a language game where English is converted to a pretendy old language.
  # The first letter of each word in a string is moved to the end, then the letters "ay" are added.
  # Example: pigify("The die is cast") => "Hetay ieday siay astcay"

  def test_pig_latin()
    expected = "Hetay ieday siay astcay"
    actual = pigify("The die is cast")
    assert_equal(expected, actual)
  end

end
