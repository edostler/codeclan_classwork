DROP TABLE films CASCADE;
DROP TABLE customers CASCADE;
DROP TABLE tickets CASCADE;
DROP TABLE screenings CASCADE;

CREATE TABLE films (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255),
  price INT
);

CREATE TABLE customers (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  funds INT
);

CREATE TABLE screenings (
	id SERIAL PRIMARY KEY,
	film_id INT REFERENCES films(id) ON DELETE CASCADE,
	show_time VARCHAR(255),
  available_tickets INT,
  sold_tickets INT
);

CREATE TABLE tickets (
  id SERIAL PRIMARY KEY,
  film_id INT REFERENCES films(id) ON DELETE CASCADE,
  customer_id INT REFERENCES customers(id) ON DELETE CASCADE,
  screening_id INT REFERENCES screenings(id) ON DELETE CASCADE,
  status VARCHAR(255)
);
