require('minitest/rg')
require('minitest/autorun')
require_relative('../w02d1_homework')

class TestStudent < MiniTest::Test

  def setup
    @student = Student.new("Ed", 4)
  end

  def test_student_name
    assert_equal("Ed", @student.student_name())
  end

  def test_student_cohort
    assert_equal(4, @student.student_cohort())
  end

  def test_set_student_name
    assert_equal("Phil", @student.set_student_name("Phil"))
  end

  def test_set_student_cohort
    assert_equal(3, @student.set_student_cohort(3))
  end

  def test_get_student_to_talk
    assert_equal("I can talk!", @student.get_student_to_talk)
  end

  def test_get_students_favourite_language
    assert_equal("I love Ruby", @student.get_students_favourite_language("Ruby"))
  end

end


class TestTeam < MiniTest::Test

  def test_team_name
    team = Team.new("NUFC", ["Alan", "Ed"], "Bobby")
    assert_equal("NUFC", team.name())
  end

  def test_team_players
    team = Team.new("NUFC", ["Alan", "Ed"], "Bobby")
    assert_equal(["Alan", "Ed"], team.players())
  end

  def test_team_coach
    team = Team.new("NUFC", ["Alan", "Ed"], "Bobby")
    assert_equal("Bobby", team.coach())
  end

  def test_set_team_coach
    team = Team.new("NUFC", ["Alan", "Ed"], "Bobby")
    team.coach = "Kevin"
    assert_equal("Kevin", team.coach())
  end

  def test_add_player
    team = Team.new("NUFC", ["Alan", "Ed"], "Bobby")
    team.add_player("Shay")
    assert_equal(3, team.players().count())
  end

  def test_check_player__found
    team = Team.new("NUFC", ["Alan", "Ed"], "Bobby")
    assert_equal(true, team.check_player("Alan"))
  end

  def test_check_player__not_found
    team = Team.new("NUFC", ["Alan", "Ed"], "Bobby")
    assert_equal(false, team.check_player("Shay"))
  end

  def test_team_points
    team = Team.new("NUFC", ["Alan", "Ed"], "Bobby")
    assert_equal(0, team.points())
  end

  def test_win_or_lose__win
    team = Team.new("NUFC", ["Alan", "Ed"], "Bobby")
    team.win_or_lose("Win")
    assert_equal(3, team.points())
  end

  def test_win_or_lose__lose
    team = Team.new("NUFC", ["Alan", "Ed"], "Bobby")
    team.win_or_lose("Lose")
    assert_equal(0, team.points())
  end

end


class TestLibrary < MiniTest::Test

  def setup
    @book1 = {
      title: "lord_of_the_rings",
      rental_details: {
        student_name: "Jeff",
        date: "01/02/18"
      }
    }
    @book2 = {
      title: "the_hollow_chocolate_bunnies_of_the_apocalypse",
      rental_details: {
        student_name: "Ed",
        date: "07/11/18"
      }
    }
    @book3 = {
      title: "guards!_guards!",
      rental_details: {
        student_name: "Emma",
        date: "12/01/18"
      }
    }

    @library = Library.new([@book1, @book2, @book3])

  end

  def test_library_book

    assert_equal([@book1, @book2, @book3], @library.books())

  end

  def test_check_book_details

    result = @library.check_book_details(@book2[:title])

    assert_equal(@book2, result)

  end

  def test_check_book_rental_details

    result = @library.check_book_rental_details(@book2[:title])

    assert_equal(@book2[:rental_details], result)

  end

  def test_add_book

    book4 = {
      title: "the_winds_of_winter",
      rental_details: {
        student_name: "",
        date: ""
      }
    }

    @library.add_book("the_winds_of_winter")

    assert_equal([@book1, @book2, @book3, book4], @library.books())

  end

  def test_update_rental_details

    book3new = {
      title: "guards!_guards!",
      rental_details: {
        student_name: "Steve",
        date: "03/02/18"
      }
    }

    @library.update_rental_details("guards!_guards!", "Steve", "03/02/18")

    assert_equal([@book1, @book2, book3new], @library.books())

  end

end
