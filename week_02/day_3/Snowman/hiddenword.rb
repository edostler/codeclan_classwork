class HiddenWord

  attr_reader :word

  def initialize(word)
    @word = word
  end

  def create_decrypted_array()
    return decrypted_array = @word.split("")
  end

  def create_encrypted_array(decrypted_array)
    encrypted_array = []
    counter = 0
    for letter in decrypted_array
      if letter != " "
        encrypted_array[counter] = "*"
        counter += 1
      end
    end
    return encrypted_array
  end

  def create_encrypted_string(encrypted_array)
    return encrypted_string = encrypted_array.join()
  end

  def check_guessed_letter(guessed_letter)
    decrypted_array = create_decrypted_array()
    for letter in decrypted_array
      if letter == guessed_letter
        return true
      end
    end
    return false
  end

  def reveal_guessed_letters(guessed_letters)
    decrypted_array = create_decrypted_array()
    encrypted_array = create_encrypted_array(decrypted_array)
    for guessed_letter in guessed_letters
      if check_guessed_letter(guessed_letter)
        counter = 0
        for letter in decrypted_array
          if letter == guessed_letter
            encrypted_array[counter] = guessed_letter
          end
          counter += 1
        end
      end
    end
    return create_encrypted_string(encrypted_array)
  end

end
