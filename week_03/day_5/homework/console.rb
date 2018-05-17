require_relative("models/film")
require_relative("models/customer")
require_relative("models/ticket")
require_relative("models/screening")

require("pry-byebug")

Ticket.delete_all()
Film.delete_all()
Customer.delete_all()

customer1 = Customer.new ({
  "name" => "Ed",
  "funds" => 100
  })
customer1.save()
customer2 = Customer.new ({
  "name" => "Ellie",
  "funds" => 30
  })
customer2.save()
customer3 = Customer.new ({
  "name" => "Danny",
  "funds" => 50
  })
customer3.save()

film1 = Film.new ({
  "title" => "IT",
  "price" => 10
  })
film1.save()
film2 = Film.new ({
  "title" => "The Stand",
  "price" => 20
  })
film2.save()
film3 = Film.new ({
  "title" => "The Dark Tower",
  "price" => 15
  })
film3.save()

screening1 = Screening.new ({
  "film_id" => film1.id,
  "show_time" => "16:05",
  "available_tickets" => 5,
  "sold_tickets" => 0
  })
screening1.save
screening2 = Screening.new ({
  "film_id" => film1.id,
  "show_time" => "17:35",
  "available_tickets" => 5,
  "sold_tickets" => 0
  })
screening2.save
screening3 = Screening.new ({
  "film_id" => film1.id,
  "show_time" => "19:05",
  "available_tickets" => 5,
  "sold_tickets" => 0
  })
screening3.save
screening4 = Screening.new ({
  "film_id" => film2.id,
  "show_time" => "16:15",
  "available_tickets" => 2,
  "sold_tickets" => 0
  })
screening4.save
screening5 = Screening.new ({
  "film_id" => film2.id,
  "show_time" => "19:05",
  "available_tickets" => 5,
  "sold_tickets" => 0
  })
screening5.save
screening6 = Screening.new ({
  "film_id" => film2.id,
  "show_time" => "22:05",
  "available_tickets" => 5,
  "sold_tickets" => 0
  })
screening6.save
screening7 = Screening.new ({
  "film_id" => film3.id,
  "show_time" => "16:30",
  "available_tickets" => 5,
  "sold_tickets" => 0
  })
screening7.save
screening8 = Screening.new ({
  "film_id" => film3.id,
  "show_time" => "18:30",
  "available_tickets" => 5,
  "sold_tickets" => 0
  })
screening8.save
screening9 = Screening.new ({
  "film_id" => film3.id,
  "show_time" => "20:30",
  "available_tickets" => 5,
  "sold_tickets" => 0
  })
screening9.save

ticket1 = Ticket.new ({
  "film_id" => film1.id,
  "customer_id" => customer1.id,
  "screening_id" => screening3.id,
  "status" => ""
  })
ticket1.buy_ticket(ticket1)
ticket2 = Ticket.new ({
  "film_id" => film2.id,
  "customer_id" => customer1.id,
  "screening_id" => screening4.id,
  "status" => ""
  })
ticket2.buy_ticket(ticket2)
ticket3 = Ticket.new ({
  "film_id" => film2.id,
  "customer_id" => customer2.id,
  "screening_id" => screening4.id,
  "status" => ""
  })
ticket3.buy_ticket(ticket3)
ticket4 = Ticket.new ({
  "film_id" => film3.id,
  "customer_id" => customer2.id,
  "screening_id" => screening9.id,
  "status" => ""
  })
ticket4.buy_ticket(ticket4)
ticket5 = Ticket.new ({
  "film_id" => film1.id,
  "customer_id" => customer3.id,
  "screening_id" => screening3.id,
  "status" => ""
  })
ticket5.buy_ticket(ticket5)
ticket6 = Ticket.new ({
  "film_id" => film2.id,
  "customer_id" => customer3.id,
  "screening_id" => screening4.id,
  "status" => ""
  })
ticket6.buy_ticket(ticket6)
ticket7 = Ticket.new ({
  "film_id" => film3.id,
  "customer_id" => customer3.id,
  "screening_id" => screening8.id,
  "status" => ""
  })
ticket7.buy_ticket(ticket7)

binding.pry
nil
