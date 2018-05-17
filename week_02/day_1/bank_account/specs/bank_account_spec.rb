require('minitest/rg')
require('minitest/autorun')
require_relative('../bank_account')

class TestBankAccount < MiniTest::Test

  def test_account_name
    bank_account = BankAccount.new("John", 500, "business")
    assert_equal("John", bank_account.holder_name())
  end

  def test_account_amount
    bank_account = BankAccount.new("John", 500, "business")
    assert_equal(500, bank_account.amount())
  end

  def test_account_type
    bank_account = BankAccount.new("John", 500, "business")
    assert_equal("business", bank_account.type())
  end

  def test_set_account_name
    bank_account = BankAccount.new("John", 500, "business")
    bank_account.holder_name = "Steve"
    assert_equal("Steve", bank_account.holder_name())
  end

  def test_set_account_amount
    bank_account = BankAccount.new("John", 500, "business")
    bank_account.amount = 700
    assert_equal(700, bank_account.amount())
  end

  def test_set_account_type
    bank_account = BankAccount.new("John", 500, "business")
    bank_account.type = 'personal'
    assert_equal('personal', bank_account.type())
  end

  def test_direct_debit__business
    bank_account = BankAccount.new("John", 500, "business")
    bank_account.direct_debit()
    assert_equal(400, bank_account.amount())
  end

  def test_direct_debit__personal
    bank_account = BankAccount.new("John", 500, "personal")
    bank_account.direct_debit()
    assert_equal(450, bank_account.amount())
  end

  def test_deposit
    bank_account = BankAccount.new("John", 500, "personal")
    bank_account.deposit(150)
    assert_equal(650, bank_account.amount())
  end

end
