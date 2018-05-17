require('minitest/autorun')
require('minitest/rg')

require_relative('../hiddenword.rb')

class HiddenWordTest < MiniTest::Test

  def setup
    @hiddenword = HiddenWord.new("snowman")
  end

  def test_get_word
    assert_equal("snowman", @hiddenword.word())
  end

  def test_create_decrypted_array
    assert_equal(["s","n","o","w","m","a","n"], @hiddenword.create_decrypted_array())
  end

  def test_create_encrypted_array
    decrypted_array = @hiddenword.create_decrypted_array()
    result = @hiddenword.create_encrypted_array(decrypted_array)
    assert_equal(["*","*","*","*","*","*","*"], result)
  end

  def test_create_encrypted_string
    decrypted_array = @hiddenword.create_decrypted_array()
    encrypted_array = @hiddenword.create_encrypted_array(decrypted_array)
    result = @hiddenword.create_encrypted_string(encrypted_array)
    assert_equal('*******', result)
  end

  def test_check_guessed_letter__true
    guessed_letter = 'n'
    result = @hiddenword.check_guessed_letter(guessed_letter)
    assert_equal(true, result)
  end

  def test_check_guessed_letter__false
    guessed_letter = 'z'
    result = @hiddenword.check_guessed_letter(guessed_letter)
    assert_equal(false, result)
  end

end
