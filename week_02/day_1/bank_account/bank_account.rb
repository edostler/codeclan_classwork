# def get_account_name(account)
#   return account[:holder_name]
# end

class BankAccount

  attr_accessor :holder_name, :amount, :type

  def initialize(input_holder_name, input_amount, input_type)
    @holder_name = input_holder_name
    @amount = input_amount
    @type = input_type
  end

  def direct_debit
    @amount -= 50 if @type == 'personal'
    @amount -= 100 if @type == 'business'
  end

  def deposit(dep_amount)
    self.amount += dep_amount
  end

end
