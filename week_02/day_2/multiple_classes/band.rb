class Band

  attr_reader :name

  def initialize(name, members)
    @name = name
    @members = members
  end

  def perform(title)
    performance = []
    for member in @members
      performance << member.play_song(title)
    end
    return performance
  end

end
