require('minitest/autorun')
require('minitest/rg')
require_relative('../bus_stop.rb')
require_relative('../person.rb')

class BusStopTest < MiniTest::Test

  def setup
    @passenger1 = Person.new('Ed', 31)
    @busstop = BusStop.new('Ocean Terminal')
  end

  def test_count_queue
    assert_equal(0, @busstop.count_queue())
  end

  def test_add_to_queue
    @busstop.add_to_queue(@passenger1)
    assert_equal(1, @busstop.count_queue())
  end

end
