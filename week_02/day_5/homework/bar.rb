class Bar

  attr_accessor :name, :till, :stock, :rooms, :all_songs

  def initialize(name, till, stock)
    @name = name
    @till = till
    @stock = stock
    @rooms = []
    @all_songs = []
    @entry_fee = 15
    @drink_fee = 4
  end

  # count arrays
  def count_rooms
    return @rooms.count()
  end
  def count_all_songs
    return @all_songs.count()
  end

  # add/remove to/from arrays
  def add_room(room)
    @rooms << room.name
  end
  def add_song_to_bar(song)
    @all_songs << song.name
  end
  def remove_room(room)
    @rooms.delete(room.name)
  end
  def remove_song_from_bar(song)
    @all_songs.delete(song.name)
  end

  # till/stock add/remove functions
  def take_entry_fee
    @till += @entry_fee
  end
  def take_drink_fee(drinks)
    @till += (@drink_fee * drinks)
  end
  def add_drink(drinks)
    @stock += drinks
  end
  def remove_drink(drinks)
    @stock -= drinks
  end

  # checks-in guest if the guest has enough money and the room has enough capacity, also returns 2 different values dependent on whether the room has the guests favourite song
  def check_in_guest_to_room(guest, room)
    if guest.cash >= @entry_fee
      if room.room_cap > room.count_guests()
        take_entry_fee()
        guest.remove_cash_from_wallet(@entry_fee)
        room.add_guest(guest)
        songs = room.get_songs_copy
        guest_song = guest.fav_song
        for song in songs
          if song == guest_song
            return "Ahhhh, tuuuuuuune!"
          else
            return "Guest checked in!"
          end
        end
      else
        return "Unfortunately, that room is at capacity."
      end
    else
      return "Unfortunately, the guest does not have enough cash to gain entry."
    end
  end

  # take a drinks order if the guest has enough cash to make the order, reduces stock and increases till
  def take_drink_order(guest, drinks)
    if guest.cash >= @drink_fee
      if @stock >= drinks
        take_drink_fee(drinks)
        cost = drinks * @drink_fee
        guest.remove_cash_from_wallet(cost)
        remove_drink(drinks)
        return "#{drinks} drinks sold!"
      else
        return "Unfortunately, there is not enough stock to satisfy this drinks order."
      end
    else
      return "Unfortunately, the guest does not have enough cash to buy that many drinks."
    end
  end

end
