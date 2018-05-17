require('minitest/autorun')
require('minitest/rg')
require_relative('../bus.rb')
require_relative('../person.rb')
require_relative('../bus_stop.rb')

class BusTest < MiniTest::Test

  def setup
    @passenger1 = Person.new('Ed', 31)
    @passenger2 = Person.new('Emma', 27)
    @busstop = BusStop.new('Ocean Terminal')
    @bus = Bus.new(22, 'Ocean Terminal')
  end

  def test_drive
    assert_equal('Brum brum', @bus.drive())
  end

  def test_count_passengers
    assert_equal(0, @bus.count_passengers())
  end

  def test_pick_up
    @bus.pick_up(@passenger1)
    assert_equal(1, @bus.count_passengers())
  end

  def test_drop_off
    @bus.pick_up(@passenger1)
    @bus.drop_off(@passenger1)
    assert_equal(0, @bus.count_passengers())
  end

  def test_remove_all
    @bus.pick_up(@passenger1)
    @bus.pick_up(@passenger2)
    @bus.remove_all()
    assert_equal(0, @bus.count_passengers())
  end

  def test_pick_up_from_stop
    @busstop.add_to_queue(@passenger1)
    @busstop.add_to_queue(@passenger2)
    @bus.pick_up_from_stop(@busstop)
    assert_equal(0, @busstop.count_queue())
    assert_equal(2, @bus.count_passengers())
  end

end
