require "minitest/autorun"
require "minitest/rg"

require_relative "../mob"

class TddPractice < MiniTest::Test

  # Task 3: Book Orders
  # Take a hash that contains a customer's book order, like this:
  # order = {
  #   name: "John",
  #   items: [
  #     {title: "The Crow Road", author: "Ian Banks", price: 7.99, quantity: 1},
  #     {title: "Dune", author: "Frank Herbert", price: 9.99, quantity: 2},
  #     {title: "And Then There Were None", author: "Agatha Christie", price: 9.99, quantity: 2}
  #   ]
  # }
  # Your method should return a string that tells us the customer name, and their total. For example:
  # "John's total is £43.16"
  # BUT. Each unique book in the order, after the first book, should give the user a 5% discount (up to a maximum of 50%).
  # So in the hash above, the customer has bought 3 unique books, and should get a 10% discount.
  # (7.99 + 9.99 + 9.99 + 9.99 + 9.99) - 10% == 47.95 - 10% == 43.16

  def test_book_order()
    order = {
      name: "John",
      items: [
        {title: "The Crow Road", author: "Ian Banks", price: 7.99, quantity: 1},
        {title: "Dune", author: "Frank Herbert", price: 9.99, quantity: 2},
        {title: "And Then There Were None", author: "Agatha Christie", price: 9.99, quantity: 2}
      ]
    }

    expected = "John's total is £43.16"
    actual = book_order(order)
    assert_equal(expected, actual)
  end

end
