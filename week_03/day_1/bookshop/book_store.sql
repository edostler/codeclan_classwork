-- use the terminal command 'createdb <name>' to quickly add a new database to psql

DROP TABLE books;
DROP TABLE authors;

CREATE TABLE authors(
  id SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL,
  age INT
);

INSERT INTO authors (name, age) VALUES ('Robert Rankin', 66);
INSERT INTO authors (name, age) VALUES ('Stephen King', 68);

SELECT * FROM authors;

CREATE TABLE books(
  id SERIAL NOT NULL,
  title VARCHAR(255) NOT NULL,
  price FLOAT,
  author INT REFERENCES authors(id) NOT NULL
);

INSERT INTO books (title, price, author) VALUES ('The Hollow Chocolate Bunnies of the Apocolypse', 6.99, 1);
INSERT INTO books (title, price, author) VALUES ('The Anti-Pope', 4.01, 1);
INSERT INTO books (title, price, author) VALUES ('The Brentford Chainsaw Massacre', 5.29, 1);
INSERT INTO books (title, price, author) VALUES ('Spouts of Wrath', 5.11, 1);
INSERT INTO books (title, price, author) VALUES ('IT', 7.99, 2);
INSERT INTO books (title, price, author) VALUES ('The Stand', 8.99, 2);
INSERT INTO books (title, price, author) VALUES ('The Gunslinger', 10.01, 2);
INSERT INTO books (title, price, author) VALUES ('The Shawshank Redemption', 15.01, 2);

SELECT * FROM books;
