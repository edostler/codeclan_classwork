import React, {Component} from "react";
import Header from '../components/Header';
import PlayerDisplay from "../components/PlayerDisplay";
import BoardTable from "../components/BoardTable";
import StatusDisplay from "../components/StatusDisplay";
import './GameContainer.css';

class GameContainer extends Component{

  constructor(props){
    super(props)
    this.state = {
      currentPlayer: 1,
      currentPlayerDisplay: "X",
      // currentPlayer values of 1 or 2 indicating player 1/X or player 2/O respectively
      currentStatus: 1,
      // currentStatus values of 0 or 1 indicating game over or game in play respectively. Status 2 indicates a drawn game.
      positions: [0, 0, 0, 0, 0, 0, 0, 0, 0],
      displayPositions: ["", "", "", "", "", "", "", "", ""],
      // position values of 0/"", 1/X or 2/O indicating position empty, position taken by player 1 or position taken by player 2 respectively
      winMatrix: [[0,1,2], [3,4,5], [6,7,8], [0,3,6], [1,4,7], [2,5,8], [0,4,8], [2,4,6]]
    }
    this.handleMove = this.handleMove.bind(this);
  }

  handleMove(position) {
    if (this.state.currentStatus > 0) {
      if (this.state.positions[position] === 0) {
        let currentPositions = this.state.positions;
        currentPositions[position] = this.state.currentPlayer;
        let currentDisplayPositions = this.state.displayPositions;
        currentDisplayPositions[position] = this.state.currentPlayerDisplay;
        this.setState({
          displayPositions: currentDisplayPositions,
          positions: currentPositions
        }, this.checkWin);
      }
    }
  }

  changePlayer() {
    if (this.state.currentPlayer === 1) {
      this.setState({
        currentPlayer: 2,
        currentPlayerDisplay: "O"
      });
    }
    else {
      this.setState({
        currentPlayer: 1,
        currentPlayerDisplay: "X"
      });
    }
  }

  checkWin() {
    let winStatus = 0;
    // loop through winMatrix array positions to check for matching winning scenarios, if one found set winStatus = 1
    this.state.winMatrix.forEach(function(winningArray){
      if ((((this.state.positions[winningArray[0]] + this.state.positions[winningArray[1]] + this.state.positions[winningArray[2]]) / this.state.currentPlayer) === 3) && this.state.positions[winningArray[0]] && this.state.positions[winningArray[1]] && this.state.positions[winningArray[2]]) {
        winStatus = 1;
      }
    }.bind(this));
    // check winStatus, draw scenario or else change player
    if (winStatus === 1) {
      this.setState({
        currentStatus: 0
      });
    }
    else if (this.state.positions[0] && this.state.positions[1] && this.state.positions[2] && this.state.positions[3] && this.state.positions[4] && this.state.positions[5] && this.state.positions[6] && this.state.positions[7] && this.state.positions[8]) {
      this.setState({
        currentStatus: 2
      });
    }
    else {
      this.changePlayer();
    }
  }

  render(){
    return(
      <div className="game-container">
        <Header
          title="Noughts and Crosses"
        />
        <PlayerDisplay
          currentPlayerDisplay={this.state.currentPlayerDisplay}
        />
        <BoardTable
          displayPositions={this.state.displayPositions}
          handleMove={this.handleMove}
        />
        <StatusDisplay
          currentStatus={this.state.currentStatus}
          currentPlayer={this.state.currentPlayer}
        />
      </div>
    );
  }

}

export default GameContainer;
