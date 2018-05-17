def pigify(phrase)
  split_array = phrase.downcase().split(' ')
  pigified_words = []
  for word in split_array
    first_letter = word.slice!(0)
    swapped_word = word + first_letter
    pigified_word = swapped_word + "ay"
    pigified_words << pigified_word
  end
  pigified_words[0].capitalize!()
  return pigified_words.join(' ')
end
