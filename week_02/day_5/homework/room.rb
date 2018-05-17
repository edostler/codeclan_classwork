class Room

  attr_accessor :name, :room_cap, :song_cap, :guests, :songs

  def initialize(name, room_cap)
    @name = name
    @room_cap = room_cap
    @song_cap = 3
    @guests = []
    @songs = []
  end

  # count arrays
  def count_guests
    return @guests.count()
  end
  def count_songs
    return @songs.count()
  end

  # add/remove to/from arrays
  def add_guest(guest)
    @guests << guest.name
  end
  def add_song_to_room(song)
    @songs << song.name
  end
  def remove_guest(guest)
    @guests.delete(guest.name)
  end
  def remove_song_from_room(song)
    @songs.delete(song.name)
  end

  # copy of songs to use in bar functions
  def get_songs_copy()
    copy = @songs
    return copy
  end

end
