require('minitest/autorun')
require('minitest/rg')

require_relative('../room')
require_relative('../guest')
require_relative('../song')

class RoomTest < MiniTest::Test

  def setup
    @room = Room.new("Pop-Punk Paradise", 5)
  end

  # test get/sets
  def test_get_room_name
    result = @room.name
    assert_equal("Pop-Punk Paradise", result)
  end
  def test_get_room_room_cap
    result = @room.room_cap
    assert_equal(5, result)
  end
  def test_set_room_name
    @room.name = "Slightly Angrier Pop-Punk Paradise"
    result = @room.name
    assert_equal("Slightly Angrier Pop-Punk Paradise", result)
  end
  def test_set_room_room_cap
    @room.room_cap = 8
    result = @room.room_cap
    assert_equal(8, result)
  end

  # test count arrays
  def test_count_guests
    result = @room.count_guests()
    assert_equal(0, result)
  end
  def test_count_songs
    result = @room.count_songs()
    assert_equal(0, result)
  end

  #test add/remove to/from arrays
  def test_add_guest
    guest = Guest.new("Ed", 100, "Blink 182 - Anthem Part 2")
    @room.add_guest(guest)
    result = @room.count_guests()
    assert_equal(1, result)
  end
  def test_add_song_to_room
    song = Song.new("Blink 182 - Anthem Part 2")
    @room.add_song_to_room(song)
    result = @room.count_songs()
    assert_equal(1, result)
  end
  def test_remove_guest
    guest = Guest.new("Ed", 100, "Blink 182 - Anthem Part 2")
    @room.add_guest(guest)
    @room.remove_guest(guest)
    result = @room.count_guests()
    assert_equal(0, result)
  end
  def test_remove_song_from_room
    song = Song.new("Blink 182 - Anthem Part 2")
    @room.add_song_to_room(song)
    @room.remove_song_from_room(song)
    result = @room.count_songs()
    assert_equal(0, result)
  end

  # copy of songs to use in bar functions
  def test_get_songs_copy
    song = Song.new("Blink 182 - Anthem Part 2")
    @room.add_song_to_room(song)
    result = @room.get_songs_copy
    assert_equal(["Blink 182 - Anthem Part 2"], result)
  end

end
