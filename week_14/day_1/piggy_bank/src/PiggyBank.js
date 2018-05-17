import React from "react";

class PiggyBank extends React.Component{

  constructor(props){
    super(props);
    this.deposit = this.deposit.bind(this);
    this.withdraw = this.withdraw.bind(this);
    this.state = {
      total: 0,
      owner: "Ed",
      deposit_amount: 10,
      withdraw_amount: 5,
    }
    this.handleOwnerChange = this.handleOwnerChange.bind(this);
    this.handleDepositChange = this.handleDepositChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  deposit(){
    this.setState(prevState => {
      return {total: prevState.total + prevState.deposit_amount};
    });
  }

  withdraw(){
    this.setState(prevState => {
      return {total: prevState.total - prevState.withdraw_amount};
    });
  }

  handleOwnerChange(event) {
    this.setState({owner: event.target.value});
  }

  handleDepositChange(event) {
    this.setState({deposit_amount: parseInt(event.target.value)});
  }

  handleSubmit(event) {
    event.preventDefault();
  }

  render(){
    return (
      <div className = "bank-box">
        <h1>{this.props.title}</h1>
        <p>I contain £{this.state.total}</p>
        <button onClick={this.deposit}>Add</button>
        <button onClick={this.withdraw}>Withdraw</button>

        <form onSubmit={this.handleSubmit}>
          <label>
            Name:
            <input type="text" owner={this.state.owner} onChange={this.handleOwnerChange} />
          </label>
          {/* <input type="submit" value="Change Owner" /> */}
        </form>

        <form onSubmit={this.handleSubmit}>
          <label>
            Amount:
            <input type="number" deposit_amount={this.state.deposit_amount} onChange={this.handleDepositChange} />
          </label>
          <input type="submit" value="Set Deposit Amount" />
        </form>

      </div>
    );
  }
}

export default PiggyBank;
