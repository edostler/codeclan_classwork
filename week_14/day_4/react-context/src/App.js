import React, { Component } from 'react';
import './App.css';

const UserContext = React.createContext();



class App extends Component {

  constructor(props){
    super(props)
    this.state = {
      name: "Ed",
      age: 31
    };
    this.makeYounger = this.makeYounger.bind(this);
  }

  makeYounger(){
    this.setState({age: this.state.age - 1});
  }

  render() {
    return (
      <UserContext.Provider value={{state: this.state, clickHandler: this.makeYounger}}>
        <Content/>
      </UserContext.Provider>
    );
  }
}

const Content = (props) => {
  return <SubContent/>
}

const SubContent = (props) => {
  return (
    <UserContext.Consumer>
      {context => {
        return (
          <React.Fragment>
            <p>{context.state.name} is {context.state.age} years old</p>
            <button onClick={context.clickHandler}>Drink from the fountain of youth</button>
          </React.Fragment>
        );
      }
      }
    </UserContext.Consumer>
  );
}

export default App;
