require_relative('../models/student')
require_relative('../models/house')

require('pry-byebug')

Student.delete_all
House.delete_all

house1 = House.new({
    "name" => "Gryffindor",
    "logo" => "gryffindor.jpg"
  })
house1.save()
house2 = House.new({
    "name" => "Slytherin",
    "logo" => "slytherin.jpg"
  })
house2.save()
house3 = House.new({
    "name" => "Hufflepuff",
    "logo" => "hufflepuff.jpg"
  })
house3.save()
house4 = House.new({
    "name" => "Ravenclaw",
    "logo" => "ravenclaw.jpg"
  })
house4.save()

student1 = Student.new({
    "first_name" => "Harry",
    "last_name" => "Potter",
    "house_id" => house1.id,
    "age" => 12
  })
student1.save()
student2 = Student.new({
    "first_name" => "Hermione",
    "last_name" => "Granger",
    "house_id" => house1.id,
    "age" => 12
  })
student2.save()
student3 = Student.new({
    "first_name" => "Draco",
    "last_name" => "Malfoy",
    "house_id" => house2.id,
    "age" => 12
  })
student3.save()
student4 = Student.new({
    "first_name" => "Luna",
    "last_name" => "Lovegood",
    "house_id" => house4.id,
    "age" => 12
  })
student4.save()
student5 = Student.new({
    "first_name" => "Fred",
    "last_name" => "Weasley",
    "house_id" => house1.id,
    "age" => 14
  })
student5.save()

binding.pry
nil
