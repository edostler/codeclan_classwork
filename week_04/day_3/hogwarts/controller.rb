require('sinatra')
require('sinatra/contrib/all')
require('pry-byebug')

require_relative('./models/student')
require_relative('./models/house')

# index
get '/students' do
  @students = Student.all
  erb(:students)
end

# create
post '/students' do
  @student = Student.new(params)
  @student.save()
  redirect to ("/students")
end

# new
get '/students/new' do
  @houses = House.all()
  erb(:new)
end
