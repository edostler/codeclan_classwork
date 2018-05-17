require("pry")
require_relative("models/pizza_order")
require_relative("models/customer")

PizzaOrder.delete_all
Customer.delete_all

customer1 = Customer.new({
  "name" => "Jeff Bridges"
})
customer1.save
customer2 = Customer.new({
  "name" => "Kevin Bridges"
})
customer2.save

pizza_order1 = PizzaOrder.new({
  "customer_id" => customer1.id,
  "topping" => "All meat",
  "quantity" => 2
  })
pizza_order1.save
pizza_order2 = PizzaOrder.new({
  "customer_id" => customer1.id,
  "topping" => "Ewok",
  "quantity" => 1
  })
pizza_order2.save
pizza_order3 = PizzaOrder.new({
  "customer_id" => customer2.id,
  "topping" => "Cheese",
  "quantity" => 3
  })
pizza_order3.save

binding.pry
nil
