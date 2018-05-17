class Guest

  attr_accessor :name, :cash, :fav_song

  def initialize(name, cash, fav_song)
    @name = name
    @cash = cash
    @fav_song = fav_song
  end

  # remove cash function
  def remove_cash_from_wallet(cost)
    @cash -= cost
  end

end
