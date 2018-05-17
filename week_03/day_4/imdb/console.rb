require_relative("models/movie")
require_relative("models/movie_star")
require_relative("models/casting")

require("pry-byebug")

Casting.delete_all()
Movie.delete_all()
MovieStar.delete_all()

movie_star1 = MovieStar.new ({
  "first_name" => "Tom",
  "last_name" => "Cruise"
  })
movie_star1.save()
movie_star2 = MovieStar.new ({
  "first_name" => "Simon",
  "last_name" => "Pegg"
  })
movie_star2.save()
movie_star3 = MovieStar.new ({
  "first_name" => "Nick",
  "last_name" => "Frost"
  })
movie_star3.save()

movie1 = Movie.new ({
  "title" => "Mission Impossible 4",
  "genre" => "Action",
  "rating" => 2,
  "budget" => 1000000
  })
movie1.save()
movie2 = Movie.new ({
  "title" => "Shaun Of The Dead",
  "genre" => "Comedy",
  "rating" => 5,
  "budget" => 300000
  })
movie2.save()

casting1 = Casting.new ({
  "movie_id" => movie1.id,
  "movie_star_id" => movie_star1.id,
  "fee" => 1000000
  })
casting1.save()
casting1.budget()
casting2 = Casting.new ({
  "movie_id" => movie1.id,
  "movie_star_id" => movie_star2.id,
  "fee" => 250000
  })
casting2.save()
casting2.budget()
casting3 = Casting.new ({
  "movie_id" => movie2.id,
  "movie_star_id" => movie_star2.id,
  "fee" => 100000
  })
casting3.save()
casting3.budget()
casting4 = Casting.new ({
  "movie_id" => movie2.id,
  "movie_star_id" => movie_star3.id,
  "fee" => 100000
  })
casting4.save()
casting4.budget()

binding.pry
nil
