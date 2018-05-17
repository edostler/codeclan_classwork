require_relative("../db/sql_runner")

class MovieStar

  attr_reader :id
  attr_accessor :first_name, :last_name

  def initialize(options)
    @id = options["id"].to_i() if options["id"]
    @first_name = options["first_name"]
    @last_name = options["last_name"]
  end

  def self.all()
    sql = "SELECT * FROM movie_stars"
    values = []
    movie_stars = SqlRunner.run(sql, values)
    return movie_stars.map {|movie_star| MovieStar.new(movie_star)}
  end

  def self.delete_all()
    sql = "DELETE FROM movie_stars"
    values = []
    SqlRunner.run(sql, values)
  end

  def save()
    sql = "INSERT INTO movie_stars (first_name, last_name) VALUES ($1, $2) RETURNING id"
    values = [@first_name, @last_name]
    movie_star = SqlRunner.run(sql, values)[0]
    @id = movie_star["id"].to_i()
  end

  def update()
    sql = "UPDATE movie_stars SET (first_name, last_name) = ($1, $2) WHERE id = $3"
    values = [@first_name, @last_name, @id]
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = "DELETE FROM movie_stars WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def movies()
    sql = "SELECT movies.* FROM movies INNER JOIN castings ON movies.id = castings.movie_id WHERE castings.movie_star_id = $1"
    values = [@id]
    movies = SqlRunner.run(sql, values)
    return movies.map {|movie| Movie.new(movie)}
  end

end
