require_relative("../db/sql_runner")

class Movie

  attr_reader :id
  attr_accessor :title, :genre, :rating, :budget

  def initialize(options)
    @id = options["id"].to_i() if options["id"]
    @title = options["title"]
    @genre = options["genre"]
    @rating = options["rating"]
    @budget = options["budget"].to_i()
  end

  def self.all()
    sql = "SELECT * FROM movies"
    values = []
    movies = SqlRunner.run(sql, values)
    return movies.map {|movie| Movie.new(movie)}
  end

  def self.delete_all()
    sql = "DELETE FROM movies"
    values = []
    SqlRunner.run(sql, values)
  end

  def save()
    sql = "INSERT INTO movies (title, genre, rating, budget) VALUES ($1, $2, $3, $4) RETURNING id"
    values = [@title, @genre, @rating, @budget]
    movie = SqlRunner.run(sql, values)[0]
    @id = movie["id"].to_i()
  end

  def update()
    sql = "UPDATE movies SET (title, genre, rating) = ($1, $2, $3) WHERE id = $4"
    values = [@title, @genre, @rating, @id]
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = "DELETE FROM movies WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def movie_stars()
    sql = "SELECT movie_stars.* FROM movie_stars INNER JOIN castings ON movie_stars.id = castings.movie_star_id WHERE castings.movie_id = $1"
    values = [@id]
    movie_stars = SqlRunner.run(sql, values)
    return movie_stars.map {|movie_star| MovieStar.new(movie_star)}
  end

end
