require('minitest/autorun')
require('minitest/rg')

require_relative('../song')

class SongTest < MiniTest::Test

  def setup
    @song = Song.new("Blink 182 - Anthem Part 2")
  end

  # test get/sets
  def test_get_song_name
    result = @song.name
    assert_equal("Blink 182 - Anthem Part 2", result)
  end
  def test_set_song_name
    @song.name = "The Offspring - Staring At The Sun"
    result = @song.name
    assert_equal("The Offspring - Staring At The Sun", result)
  end

end
