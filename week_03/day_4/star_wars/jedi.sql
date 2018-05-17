-- Had to move the DROP TABLE lightsabers to the top because we can't DROP TABLE characters when objects in the existing lightsabers tables depend on it
DROP TABLE lightsabers;
DROP TABLE characters;

CREATE TABLE characters (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  age INT,
  darkside BOOLEAN
);

INSERT INTO characters (name, age, darkside) VALUES ('Obi-Wan Kenobi', 30, false);
INSERT INTO characters (name, age, darkside) VALUES ('Anakin Skywalker', 19, false);
INSERT INTO characters (name, darkside) VALUES ('Yoda', false);

-- UPDATE characters SET age = null WHERE name = 'Obi-Wan Kenobi';
-- UPDATE characters SET darkside = true;
UPDATE characters SET darkside = true, name = 'Darth Vader' WHERE name = 'Anakin Skywalker';

-- DELETE FROM characters WHERE name = 'Obi-Wan Kenobi';

INSERT INTO characters (name, age, darkside) VALUES ('Ewok', 12, false);
INSERT INTO characters (name, age, darkside) VALUES ('Ewok', 12, false);
INSERT INTO characters (name, age, darkside) VALUES ('Ewok', 12, false);
INSERT INTO characters (name, age, darkside) VALUES ('Ewok', 12, false);
INSERT INTO characters (name, age, darkside) VALUES ('Ewok', 12, false);

DELETE FROM characters WHERE id = 6;

INSERT INTO characters (name, age, darkside) VALUES ('Poe Dameron', 32, false);

-- SELECT * FROM characters;

-- SELECT name FROM characters;
-- SELECT name, darkside FROM characters;
-- SELECT COUNT(*) FROM characters;
-- SELECT COUNT(age) FROM characters;


CREATE TABLE lightsabers (
  id SERIAL,
  colour VARCHAR(255) NOT NULL,
  hilt_metal VARCHAR(255) NOT NULL,
  owner INT REFERENCES characters(id)
);

INSERT INTO lightsabers (colour, hilt_metal, owner) VALUES ('green', 'gold', 3);
INSERT INTO lightsabers (colour, hilt_metal, owner) VALUES ('red', 'chrome', 2);
INSERT INTO lightsabers (colour, hilt_metal, owner) VALUES ('blue', 'alloy', 1);
INSERT INTO lightsabers (colour, hilt_metal, owner) VALUES ('yellow', 'bronze', 1);

-- This throws an error because we are referencing an non-existent id from characters
-- INSERT INTO lightsabers (colour, hilt_metal, owner) VALUES ('blue', 'alloy', 15);

-- Throws Error because we have now stated NOT NULL
-- INSERT INTO lightsabers (hilt_metal, owner) VALUES ('silver', 'Yoda');

-- SELECT * FROM lightsabers;



-- DAY 4 LESSON

SELECT lightsabers.colour FROM lightsabers;

-- shows the characters that match id to owner in lightsabers
SELECT characters.* FROM characters
  INNER JOIN lightsabers ON characters.id = lightsabers.owner;

-- shows info from both tables where characters and lightsabers overlap
SELECT characters.*, lightsabers.* FROM characters
  INNER JOIN lightsabers ON characters.id = lightsabers.owner;

-- shows the same as above but the other way round
SELECT lightsabers.*, characters.* FROM characters
  INNER JOIN lightsabers ON characters.id = lightsabers.owner;

-- this shows all of the characters table but also the lightsabers info where it exists
SELECT characters.*, lightsabers.* FROM characters
  LEFT JOIN lightsabers ON characters.id = lightsabers.owner;

-- this would do the opposite of the above but we don't have any lightsabers without owners
SELECT characters.*, lightsabers.* FROM characters
  RIGHT JOIN lightsabers ON characters.id = lightsabers.owner;
