require('minitest/autorun')
require('minitest/rg')

require_relative('../bar')
require_relative('../room')
require_relative('../guest')
require_relative('../song')

class BarTest < MiniTest::Test

  def setup
    @bar = Bar.new("Bill and Ed's Excellent Venture", 0, 0)
  end

  # test get/sets
  def test_get_bar_name
    result = @bar.name
    assert_equal("Bill and Ed's Excellent Venture", result)
  end
  def test_get_bar_till
    result = @bar.till
    assert_equal(0, result)
  end
  def test_get_bar_stock
    result = @bar.stock
    assert_equal(0, result)
  end
  def test_set_bar_name
    @bar.name = "Ed's Audio Emporium"
    result = @bar.name
    assert_equal("Ed's Audio Emporium", result)
  end
  def test_set_bar_till
    @bar.till = 50
    result = @bar.till
    assert_equal(50, result)
  end
  def test_set_bar_stock
    @bar.stock = 50
    result = @bar.stock
    assert_equal(50, result)
  end

  #test add/remove to/from arrays
  def test_count_rooms
    result = @bar.count_rooms()
    assert_equal(0, result)
  end
  def test_count_all_songs
    result = @bar.count_all_songs()
    assert_equal(0, result)
  end

  def test_add_room
    room = Room.new("Pop-Punk Paradise", 5)
    @bar.add_room(room)
    result = @bar.count_rooms()
    assert_equal(1, result)
  end
  def test_add_song_to_bar
    song = Song.new("Blink 182 - Anthem Part 2")
    @bar.add_song_to_bar(song)
    result = @bar.count_all_songs()
    assert_equal(1, result)
  end
  def test_remove_room
    room = Room.new("Pop-Punk Paradise", 5)
    @bar.add_room(room)
    @bar.remove_room(room)
    result = @bar.count_rooms()
    assert_equal(0, result)
  end
  def test_remove_song_from_bar
    song = Song.new("Blink 182 - Anthem Part 2")
    @bar.add_song_to_bar(song)
    @bar.remove_song_from_bar(song)
    result = @bar.count_all_songs()
    assert_equal(0, result)
  end

  # test till/stock add/remove functions
  def test_take_entry_fee
    @bar.take_entry_fee
    result = @bar.till
    assert_equal(15, result)
  end
  def test_take_drink_fee
    @bar.take_drink_fee(5)
    result = @bar.till
    assert_equal(20, result)
  end
  def test_add_drink
    @bar.add_drink(5)
    result = @bar.stock
    assert_equal(5, result)
  end
  def test_remove_drink
    @bar.add_drink(5)
    @bar.remove_drink(3)
    result = @bar.stock
    assert_equal(2, result)
  end

  # test check guest into room scenarios
  def test_check_in_guest_to_room__cash__capacity__tune
    room = Room.new("Pop-Punk Paradise", 5)
    guest = Guest.new("Ed", 100, "Blink 182 - Anthem Part 2")
    song = Song.new("Blink 182 - Anthem Part 2")
    room.add_song_to_room(song)
    result = @bar.check_in_guest_to_room(guest, room)
    result_till = @bar.till
    result_cash = guest.cash
    result_guests = room.count_guests()
    result_songs = room.count_songs()
    assert_equal("Ahhhh, tuuuuuuune!", result)
    assert_equal(15, result_till)
    assert_equal(85, result_cash)
    assert_equal(1, result_guests)
    assert_equal(1, result_songs)
  end
  def test_check_in_guest_to_room__cash__capacity__no_tune
    room = Room.new("Pop-Punk Paradise", 5)
    guest = Guest.new("Ed", 100, "Blink 182 - Anthem Part 2")
    song = Song.new("The Offspring - Staring At The Sun")
    room.add_song_to_room(song)
    result = @bar.check_in_guest_to_room(guest, room)
    result_till = @bar.till
    result_cash = guest.cash
    result_guests = room.count_guests()
    result_songs = room.count_songs()
    assert_equal("Guest checked in!", result)
    assert_equal(15, result_till)
    assert_equal(85, result_cash)
    assert_equal(1, result_guests)
    assert_equal(1, result_songs)
  end
  def test_check_in_guest_to_room__cash__no_capacity
    room = Room.new("Pop-Punk Paradise", 0)
    guest = Guest.new("Ed", 100, "Blink 182 - Anthem Part 2")
    result = @bar.check_in_guest_to_room(guest, room)
    result_till = @bar.till
    result_cash = guest.cash
    result_guests = room.count_guests()
    assert_equal("Unfortunately, that room is at capacity.", result)
    assert_equal(0, result_till)
    assert_equal(100, result_cash)
    assert_equal(0, result_guests)
  end
  def test_check_in_guest_to_room__no_cash
    room = Room.new("Pop-Punk Paradise", 5)
    guest = Guest.new("Ed", 0, "Blink 182 - Anthem Part 2")
    result = @bar.check_in_guest_to_room(guest, room)
    result_till = @bar.till
    result_cash = guest.cash
    result_guests = room.count_guests()
    assert_equal("Unfortunately, the guest does not have enough cash to gain entry.", result)
    assert_equal(0, result_till)
    assert_equal(0, result_cash)
    assert_equal(0, result_guests)
  end

  # test take_drink_order scenarios
  def test_take_drink_order__cash__stock
    guest = Guest.new("Ed", 100, "Blink 182 - Anthem Part 2")
    @bar.add_drink(10)
    result = @bar.take_drink_order(guest, 5)
    result_till = @bar.till
    result_cash = guest.cash
    result_stock = @bar.stock
    assert_equal("5 drinks sold!", result)
    assert_equal(20, result_till)
    assert_equal(80, result_cash)
    assert_equal(5, result_stock)
  end
  def test_take_drink_order__cash__no_stock
    guest = Guest.new("Ed", 100, "Blink 182 - Anthem Part 2")
    result = @bar.take_drink_order(guest, 5)
    result_till = @bar.till
    result_cash = guest.cash
    result_stock = @bar.stock
    assert_equal("Unfortunately, there is not enough stock to satisfy this drinks order.", result)
    assert_equal(0, result_till)
    assert_equal(100, result_cash)
    assert_equal(0, result_stock)
  end
  def test_take_drink_order__no_cash
    guest = Guest.new("Ed", 0, "Blink 182 - Anthem Part 2")
    result = @bar.take_drink_order(guest, 5)
    result_till = @bar.till
    result_cash = guest.cash
    result_stock = @bar.stock
    assert_equal("Unfortunately, the guest does not have enough cash to buy that many drinks.", result)
    assert_equal(0, result_till)
    assert_equal(0, result_cash)
    assert_equal(0, result_stock)
  end

end
