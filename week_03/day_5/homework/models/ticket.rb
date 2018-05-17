require_relative("../db/sql_runner")

class Ticket

  attr_reader :id
  attr_accessor :film_id, :customer_id, :screening_id, :status

  def initialize(options)
    @id = options["id"].to_i() if options["id"]
    @film_id = options["film_id"].to_i()
    @customer_id = options["customer_id"].to_i()
    @screening_id = options["screening_id"].to_i()
    @status = options["status"]
  end

  def self.all()
    sql = "SELECT * FROM tickets"
    values = []
    tickets = SqlRunner.run(sql, values)
    return tickets.map {|ticket| Ticket.new(ticket)}
  end

  def self.delete_all()
    sql = "DELETE FROM tickets"
    values = []
    SqlRunner.run(sql, values)
  end

  def self.not_sold()
    sql = "SELECT tickets.* FROM tickets WHERE status = 'NOT SOLD'"
    values = []
    not_sold = SqlRunner.run(sql, values)
    return not_sold.map {|ticket| Ticket.new(ticket)}
  end

  def save()
    sql = "INSERT INTO tickets (film_id, customer_id, screening_id, status) VALUES ($1, $2, $3, $4) RETURNING id"
    values = [@film_id, @customer_id, @screening_id, @status]
    ticket = SqlRunner.run(sql, values)[0]
    @id = ticket["id"].to_i()
  end

  def update()
    sql = "UPDATE tickets SET (film_id, customer_id, screening_id, status) = ($1, $2, $3, $4) WHERE id = $5"
    values = [@film_id, @customer_id, @screening_id, @status, @id]
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = "DELETE FROM tickets WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def customer()
    sql = "SELECT * FROM customers WHERE id = $1"
    values = [@customer_id]
    customer = SqlRunner.run(sql, values)[0]
    return Customer.new(customer)
  end

  def film()
    sql = "SELECT * FROM films WHERE id = $1"
    values = [@film_id]
    film = SqlRunner.run(sql, values)[0]
    return Film.new(film)
  end

  def screening()
    sql = "SELECT * FROM screenings WHERE id = $1"
    values = [@screening_id]
    screening = SqlRunner.run(sql, values)[0]
    return Screening.new(screening)
  end

  def pay()
    new_funds = customer.funds - film.price
    sql = "UPDATE customers SET funds = $1 WHERE id = $2"
    values = [new_funds, @customer_id]
    SqlRunner.run(sql, values)
  end

  def allocate()
    new_available_tickets = screening.available_tickets - 1
    new_sold_tickets = screening.sold_tickets + 1
    values = [new_available_tickets, @screening_id]
    sql = "UPDATE screenings SET available_tickets = $1 WHERE id = $2"
    SqlRunner.run(sql, values)
    values = [new_sold_tickets, @screening_id]
    sql = "UPDATE screenings SET sold_tickets = $1 WHERE id = $2"
    SqlRunner.run(sql, values)
  end

  def ticket_status_sold()
    sql = "UPDATE tickets SET status = 'SOLD' WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def ticket_status_not_sold()
    sql = "UPDATE tickets SET status = 'NOT SOLD' WHERE id = $1"
    values = [@id]
    SqlRunner.run(sql, values)
  end

  def buy_ticket(ticket)
    ticket.save()
    if screening.available_tickets > 0 && customer.funds >= film.price
      ticket.pay()
      ticket.allocate()
      ticket.ticket_status_sold()
    else
      ticket.ticket_status_not_sold()
    end
  end

end
