require('minitest/autorun')
require('minitest/rg')

require_relative('../guest')

class GuestTest < MiniTest::Test

  def setup
    @guest = Guest.new("Ed", 100, "Blink 182 - Anthem Part 2")
  end

  # test get/sets
  def test_get_guest_name
    result = @guest.name
    assert_equal('Ed', result)
  end
  def test_get_guest_cash
    result = @guest.cash
    assert_equal(100, result)
  end
  def test_get_guest_fav_song
    result = @guest.fav_song
    assert_equal("Blink 182 - Anthem Part 2", result)
  end
  def test_set_guest_name
    @guest.name = "Bill"
    result = @guest.name
    assert_equal("Bill", result)
  end
  def test_set_guest_cash
    @guest.cash = 55
    result = @guest.cash
    assert_equal(55, result)
  end
  def test_set_guest_fav_song
    @guest.fav_song = "The Offspring - Staring At The Sun"
    result = @guest.fav_song
    assert_equal("The Offspring - Staring At The Sun", result)
  end

  # test remove cash function
  def test_remove_cash_from_wallet
    @guest.remove_cash_from_wallet(15)
    result = @guest.cash
    assert_equal(85, result)
  end

end
