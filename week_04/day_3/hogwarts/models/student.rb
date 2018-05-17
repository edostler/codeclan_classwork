require_relative('../db/sql_runner')

class Student

  attr_reader :id
  attr_accessor :first_name, :last_name, :house_id, :age

  def initialize(options)
    @id = options["id"].to_i if options["id"]
    @first_name = options["first_name"]
    @last_name = options["last_name"]
    @house_id = options["house_id"].to_i
    @age = options["age"].to_i
  end

  def save()
    sql = "INSERT INTO students (first_name, last_name, house_id, age) VALUES ($1, $2, $3, $4) RETURNING id"
    values = [@first_name, @last_name, @house_id, @age]
    student = SqlRunner.run(sql, values)[0]
    @id = student["id"].to_i
  end

  def house()
    sql = "SELECT * FROM houses WHERE id = $1"
    values = [@house_id]
    house = SqlRunner.run(sql, values)
    return House.new(house.first)
  end

  def self.delete_all()
    sql = "DELETE FROM students"
    values = []
    SqlRunner.run(sql, values)
  end

  def self.all()
    sql = "SELECT * FROM students"
    values = []
    student = SqlRunner.run(sql, values)
    return student.map{|student| Student.new(student)}
  end

  def self.find(id)
    sql = "SELECT * FROM students WHERE id = $1"
    values = [id]
    student = SqlRunner.run(sql, values)
    result = Student.new(student.first)
    return result
  end

end
