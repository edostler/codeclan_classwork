require("PG")

class Bounty

  attr_accessor :name, :species, :bounty_value, :homeworld
  attr_reader :id

  def initialize(options)
    @name = options["name"]
    @species = options["species"]
    @bounty_value = options["bounty_value"].to_i()
    @homeworld = options["homeworld"]
    @id = options["id"].to_i() if options["id"]
  end

  def save()
    db = PG.connect({dbname: "bountyhunter", host: "localhost"})
    sql = "INSERT INTO bounties(name, species, bounty_value, homeworld) VALUES ($1, $2, $3, $4) RETURNING id"
    values = [@name, @species, @bounty_value, @homeworld]
    db.prepare("save", sql)
    @id = db.exec_prepared("save", values)[0]["id"].to_i()
    db.close()
  end

  def Bounty.delete_all()
    db = PG.connect({dbname: "bountyhunter", host: "localhost"})
    sql = "DELETE FROM bounties"
    db.prepare("delete_all", sql)
    db.exec_prepared("delete_all")
    db.close()
  end

  def delete()
    db = PG.connect({dbname: "bountyhunter", host: "localhost"})
    sql = "DELETE FROM bounties WHERE id = $1"
    values = [@id]
    db.prepare("delete_one", sql)
    db.exec_prepared("delete_one", values)
    db.close()
  end

  def update()
    db = PG.connect({dbname: "bountyhunter", host: "localhost"})
    sql = "UPDATE bounties SET (name, species, bounty_value, homeworld) = ($1, $2, $3, $4) WHERE id = $5"
    values = [@name, @species, @bounty_value, @homeworld, @id]
    db.prepare("update", sql)
    db.exec_prepared("update", values)
    db.close()
  end

  def Bounty.find_all()
    db = PG.connect({dbname: "bountyhunter", host: "localhost"})
    sql = "SELECT * FROM bounties"
    db.prepare("find_all", sql)
    bounties = db.exec_prepared("find_all")
    db.close()
    return bounties.map{|bounty| Bounty.new(bounty)}
  end

  def find_specific()
    db = PG.connect({dbname: "bountyhunter", host: "localhost"})
    sql = "SELECT * FROM bounties WHERE id = $1"
    values = [@id]
    db.prepare("all", sql)
    found_bounty = db.exec_prepared("all", values)
    db.close()
    return Bounty.new(found_bounty[0])
  end

  def Bounty.find_range()
    db = PG.connect({dbname: "bountyhunter", host: "localhost"})
    sql = "SELECT * FROM bounties WHERE bounty_value > 15000"
    db.prepare("find_range", sql)
    found_bounties = db.exec_prepared("find_range")
    db.close()
    return found_bounties.map{|bounty| Bounty.new(bounty)}
  end

end
