require_relative("../db/sql_runner")
require_relative("movie")

class Casting

  attr_reader :id
  attr_accessor :movie_id, :movie_star_id, :fee

  def initialize(options)
    @id = options["id"].to_i() if options["id"]
    @movie_id = options["movie_id"].to_i()
    @movie_star_id = options["movie_star_id"].to_i()
    @fee = options["fee"]
  end

  def self.all()
    sql = "SELECT * FROM castings"
    values = []
    castings = SqlRunner.run(sql, values)
    return castings.map {|casting| Casting.new(casting)}
  end

  def self.delete_all()
    sql = "DELETE FROM castings"
    values = []
    SqlRunner.run(sql, values)
  end

  def save()
    sql = "INSERT INTO castings (movie_id, movie_star_id, fee) VALUES ($1, $2, $3) RETURNING id"
    values = [@movie_id, @movie_star_id, @fee]
    casting = SqlRunner.run(sql, values)[0]
    @id = casting["id"].to_i()
  end

  def budget()
    sql = "UPDATE movies SET budget = (budget - $1) WHERE id = $2"
    values = [@fee, @movie_id]
    SqlRunner.run(sql, values)
  end

  def update()
    sql = "UPDATE castings SET (movie_id, movie_star_id, fee) = ($1, $2, $3) WHERE id = $4"
    values = [@movie_id, @movie_star_id, @fee, @id]
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = "DELETE FROM castings WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def movie_star()
    sql = "SELECT * FROM movie_stars WHERE id = $1"
    values = [@movie_star_id]
    movie_star = SqlRunner.run(sql, values)[0]
    return MovieStar.new(movie_star)
  end

  def movie()
    sql = "SELECT * FROM movies WHERE id = $1"
    values = [@movie_id]
    movie = SqlRunner.run(sql, values)[0]
    return Movie.new(movie)
  end

end
