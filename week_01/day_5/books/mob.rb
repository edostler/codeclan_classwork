order = {
  name: "John",
  items: [
    {title: "The Crow Road", author: "Ian Banks", price: 7.99, quantity: 1},
    {title: "Dune", author: "Frank Herbert", price: 9.99, quantity: 2},
    {title: "And Then There Were None", author: "Agatha Christie", price: 9.99, quantity: 2}
  ]
}


def book_order(data)
  unique_books = 0
  total = 0.00
  for item in data[:items]
    unique_books += 1
    total += (item[:quantity] * item[:price])
  end

  # puts unique_books
  # puts total
  discount = ((unique_books - 1) * 0.05)

  if discount > 0.5
    discount = 0.5
  end

  final_price = (total - (total * discount)).round(2)

  puts final_price

  p "#{data[:name]}'s total is £#{final_price}"

end
