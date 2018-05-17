require('minitest/autorun')
require('minitest/rg')

require_relative('../band.rb')
require_relative('../musician.rb')
require_relative('../instrument.rb')

class BandTest < MiniTest::Test

  def setup
    piano = Instrument.new("Steinway Model Z", "piano")
    guitar = Instrument.new("Gretsch", "guitar")
    drums = Instrument.new("Ludwig", "drums")
    bass = Instrument.new("Hoffner", "bass")

    john = Musician.new("John", piano)
    george = Musician.new("George", guitar)
    paul = Musician.new("Paul", bass)
    ringo = Musician.new("Ringo", drums)

    @beatles = Band.new("Beatles", [john, paul, george, ringo])

  end

  def test_band_has_name
    assert_equal("Beatles", @beatles.name)
  end

  def test_band_can_perform_song
    expected_performance = [
      "Plink-plonk... I'm playing Hey Jude!",
      "I'm playing Hey Jude!",
      "I'm playing Hey Jude!",
      "I'm playing Hey Jude!"]

    assert_equal(expected_performance, @beatles.perform("Hey Jude"))

  end

end
