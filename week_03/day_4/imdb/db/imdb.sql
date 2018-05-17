DROP TABLE movies CASCADE;
DROP TABLE movie_stars CASCADE;
DROP TABLE castings CASCADE;

CREATE TABLE movies (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255),
  genre VARCHAR(255),
  rating INT
);

ALTER TABLE movies ADD budget INT;

CREATE TABLE movie_stars (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255)
);

CREATE TABLE castings (
  id SERIAL PRIMARY KEY,
  movie_id INT REFERENCES movies(id) ON DELETE CASCADE,
  movie_star_id INT REFERENCES movie_stars(id) ON DELETE CASCADE,
  fee INT
);
