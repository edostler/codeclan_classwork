require("pry-byebug")
require_relative("models/pizza_order.rb")

order1 = PizzaOrder.new({
  "first_name" => "Luke",
  "last_name" => "Skywalker",
  "quantity" => "1",
  "topping" => "Ewok, extra Ewok"
  })

order2 = PizzaOrder.new({
  "first_name" => "Darth",
  "last_name" => "Vader",
  "quantity" => "3",
  "topping" => "Hawaiian"
  })

order1.save()
order2.save()

order1.first_name = "Fred"
order1.update()


orders = PizzaOrder.all()

binding.pry
nil
# we need to put nil here becasue ruby doesnt want a file to end with binding.pry
