
class River

  def initialize(name)
    @name = name
    @fishes = []
  end

  def count_fish()
    return @fishes.count()
  end

  def add_fish(fish)
    @fishes << fish
  end

  def remove_fish()
    return @fishes.pop()
  end

end
