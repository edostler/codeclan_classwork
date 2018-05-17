
class Bear

  def initialize(name)
    @name = name
    @stomach_contents = []
  end

  def stomach_contents
    return @stomach_contents.compact().count()
  end

  def catch_fish(fish)
    @stomach_contents << fish
  end

  def roar()
    return 'Roaaaar!'
  end

end
