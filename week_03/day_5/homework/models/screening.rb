require_relative("../db/sql_runner")

class Screening

  attr_reader :id
  attr_accessor :film_id, :show_time, :available_tickets, :sold_tickets

  def initialize(options)
    @id = options["id"].to_i() if options["id"]
    @film_id = options["film_id"].to_i()
    @show_time = options["show_time"]
    @available_tickets = options["available_tickets"].to_i()
    @sold_tickets = options["sold_tickets"].to_i()
  end

  def self.all()
    sql = "SELECT * FROM screenings"
    values = []
    screenings = SqlRunner.run(sql, values)
    return screenings.map {|screening| Screening.new(screening)}
  end

  def self.delete_all()
    sql = "DELETE FROM screenings"
    values = []
    SqlRunner.run(sql, values)
  end

  def save()
    sql = "INSERT INTO screenings (film_id, show_time, available_tickets, sold_tickets) VALUES ($1, $2, $3, $4) RETURNING id"
    values = [@film_id, @show_time, @available_tickets, @sold_tickets]
    screening = SqlRunner.run(sql, values)[0]
    @id = screening["id"].to_i()
  end

  def update()
    sql = "UPDATE screenings SET (film_id, show_time, available_tickets, sold_tickets) = ($1, $2, $3, $4) WHERE id = $5"
    values = [@film_id, @show_time, @available_tickets, @sold_tickets, @id]
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = "DELETE FROM screenings WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

end
