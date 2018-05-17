class Student

  def initialize(input_name, input_cohort)
    @name = input_name
    @cohort = input_cohort
  end

  def student_name
    return @name
  end

  def student_cohort
    return @cohort
  end

  def set_student_name(name)
    @name = name
  end

  def set_student_cohort(cohort)
    @cohort = cohort
  end

  def get_student_to_talk
    return "I can talk!"
  end

  def get_students_favourite_language(language)
    return "I love #{language}"
  end

end

class Team

  attr_reader :name, :players, :points
  attr_accessor :coach

  def initialize(input_name, input_players, input_coach)
    @name = input_name
    @players = input_players
    @coach = input_coach
    @points = 0
  end

  def add_player(name)
    @players << name
  end

  def check_player(name)
    return @players.include?(name)
  end

  def win_or_lose(result)
    if result == "Win"
      @points += 3
    end
  end

end

class Library

  attr_reader :books

  def initialize(input_books)
    @books = input_books
  end

  def check_book_details(book_name)
    for book in @books
      if book[:title] == book_name
        return book
      end
    end
  end

  def check_book_rental_details(book_name)
    for book in @books
      if book[:title] == book_name
        return book[:rental_details]
      end
    end
  end

  def add_book(new_book)
    @books << {
      title: new_book,
      rental_details: {
        student_name: "",
        date: ""
      }
    }
  end

  def update_rental_details(book_name, new_student, new_date)
    for book in @books
      if book[:title] == book_name
        book[:rental_details][:student_name] = new_student
        book[:rental_details][:date] = new_date
      end
    end
  end

end
