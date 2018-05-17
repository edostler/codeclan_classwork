# Create file structure with class.rb files in /models and .sql file in /db, while the console.rb file remains in the top level of the folder.
# Create the psql database using 'createdb <name>'
# Write DROP TABLE and CREATE TABLE in .sql with correct variable types
# Write REQUIRE for 'pry-byebug' in console.rb as well as for 'PG' in all class.rb files
# Write REQUIRE_RELATIVE to class.rb files in console.rb file
# Write binding.pry and nil at end of console.rb file
# Write all entries into console.rb and also any called functions
# Create class with attr(s) and initialize (using the @var = options["var"] syntax, remember that 'id' needs an if statement)
# Write functions in class.rb files

require("pry-byebug")
require_relative("models/bounty.rb")

bounty1 = Bounty.new({
  "name" => "Boba Fett",
  "species" => "Mandalorian",
  "bounty_value" => "20000",
  "homeworld" => "Mandalore"
  })

bounty2 = Bounty.new({
  "name" => "Jango Fett",
  "species" => "Mandalorian",
  "bounty_value" => "10000",
  "homeworld" => "Mandalore"
  })

bounty3 = Bounty.new({
  "name" => "Lando Calrissian",
  "species" => "Human",
  "bounty_value" => "50000",
  "homeworld" => "Bespin"
  })

bounty1.save
bounty2.save
bounty3.save

bounty1.name = "Han Solo"
bounty1.species = "Human"
bounty1.bounty_value = "1000000"
bounty1.homeworld = "Corellia"
bounty1.update

bounties = Bounty.find_all()

found_bounty = bounty2.find_specific()

found_bounties = Bounty.find_range()

binding.pry
nil
