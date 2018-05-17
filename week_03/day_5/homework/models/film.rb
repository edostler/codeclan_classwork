require_relative("../db/sql_runner")

class Film

  attr_reader :id
  attr_accessor :title, :price

  def initialize(options)
    @id = options["id"].to_i() if options["id"]
    @title = options["title"]
    @price = options["price"].to_i()
  end

  def self.all()
    sql = "SELECT * FROM films"
    values = []
    films = SqlRunner.run(sql, values)
    return films.map {|film| Film.new(film)}
  end

  def self.delete_all()
    sql = "DELETE FROM films"
    values = []
    SqlRunner.run(sql, values)
  end

  def save()
    sql = "INSERT INTO films (title, price) VALUES ($1, $2) RETURNING id"
    values = [@title, @price]
    film = SqlRunner.run(sql, values)[0]
    @id = film["id"].to_i()
  end

  def update()
    sql = "UPDATE films SET (title, price) = ($1, $2) WHERE id = $3"
    values = [@title, @price, @id]
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = "DELETE FROM films WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def customers()
    sql = "SELECT customers.* FROM customers INNER JOIN tickets ON customers.id = customer_id WHERE film_id = $1 AND status = 'SOLD'"
    values = [@id]
    customers = SqlRunner.run(sql, values)
    return customers.map {|customer| Customer.new(customer)}
  end

  def count_customers()
    sql = "SELECT tickets.* FROM tickets WHERE film_id = $1 AND status = 'SOLD'"
    values = [@id]
    customers = SqlRunner.run(sql, values)
    return customers.count
  end

  def most_popular_screenings()
    sql = "SELECT screenings.* FROM screenings WHERE film_id = $1 AND sold_tickets = (SELECT MAX(sold_tickets) FROM screenings WHERE film_id = $1)"
    values = [@id]
    screening = SqlRunner.run(sql, values)
    return screening.map {|screening| Screening.new(screening)}
  end

end
