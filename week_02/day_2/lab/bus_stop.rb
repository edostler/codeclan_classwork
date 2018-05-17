class BusStop

  def initialize(name)
    @name = name
    @queue = []
  end

  def count_queue()
    return @queue.count()
  end

  def add_to_queue(passenger)
    @queue << passenger
  end

  def get_queue_copy()
    copy = @queue
    return copy
  end

  def clear_queue()
    @queue.clear()
  end

end
