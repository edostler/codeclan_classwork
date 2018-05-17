require_relative('../db/sql_runner')

class House

  attr_reader :id
  attr_accessor :name, :logo

  def initialize(options)
    @id = options["id"].to_i if options["id"]
    @name = options["name"]
    @logo = options["logo"]
  end

  def save()
    sql = "INSERT INTO houses (name, logo) VALUES ($1, $2) RETURNING id"
    values = [@name, @logo]
    house = SqlRunner.run(sql, values)[0]
    @id = house["id"].to_i
  end

  def self.delete_all()
    sql = "DELETE FROM houses"
    values = []
    SqlRunner.run(sql, values)
  end

  def self.all()
      sql = "SELECT * FROM houses"
      values = []
      house = SqlRunner.run(sql, values)
      return house.map{|house| House.new(house)}
  end

  def self.find(id)
    sql = "SELECT * FROM houses WHERE id = $1"
    values = [id]
    house = SqlRunner.run(sql, values)
    return House.new(house.first)
  end

  def self.houses()
    houses = House.all
    return houses.map{|house| house.name}
  end

end
