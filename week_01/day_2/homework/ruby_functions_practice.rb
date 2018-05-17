def return_10()
return 10
end

def add(number_1, number_2)
  return number_1 + number_2
end

def subtract(number_1, number_2)
  return number_1 - number_2
end

def multiply(number_1, number_2)
  return number_1 * number_2
end

#remember that with non-integer division that you would need to check two tests, one for integer and one for non-integer
def divide(number_1, number_2)
  return number_1 / number_2
end

def length_of_string(test_string)
  return test_string.length()
end

def join_string(string_1, string_2)
  return string_1 + string_2
end

def add_string_as_number(string_1, string_2)
  return string_1.to_i() + string_2.to_i()
end

def number_to_full_month_name(month)
    return case month
    when 1
      "January"
    when 2
      "February"
    when 3
      "March"
    when 4
      "April"
    when 5
      "May"
    when 6
      "June"
    when 7
      "July"
    when 8
      "August"
    when 9
      "September"
    when 10
      "October"
    when 11
      "November"
    when 12
      "December"
    end
end

#Here we could have done a very similar piece of code to above, but we don't want to repeat ourselves to this is better.
def number_to_short_month_name(month)
  return number_to_full_month_name(month)[0..2]
end

def volume_cube(length)
  return length ** 3
end

def volume_sphere(radius)
  value = (4.0 / 3.0) * (Math::PI) * (radius ** 3)
  return value.round(0)
end

def fahrenheit_to_celsius(fahrenheit)
  return (fahrenheit - 32) / 1.8
end
