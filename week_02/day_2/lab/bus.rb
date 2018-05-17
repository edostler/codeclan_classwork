class Bus

  def initialize(route, destination)
    @route = route
    @destination = destination
    @passengers = []
  end

  def drive()
    return "Brum brum"
  end

  def count_passengers()
    return @passengers.count()
  end

  def pick_up(passenger)
    @passengers << passenger
  end

  def drop_off(passenger)
    @passengers.delete(passenger)
  end

  def remove_all()
    @passengers.clear()
  end

  def pick_up_from_stop(stop)
    for person in stop.get_queue_copy()
      pick_up(person)
    end
    stop.clear_queue()
  end

end
