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
      currentPlayerDisplay: "red_token.png",
      currentPlayerDisplayAlt: "red",
      // currentPlayer values of 1 or 2 indicating player 1/X or player 2/O respectively
      currentStatus: 1,
      // currentStatus values of 0 or 1 indicating game over or game in play respectively
      positions: [[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0]],
      displayPositions: [["blank.png", "blank.png", "blank.png", "blank.png", "blank.png", "blank.png"], ["blank.png", "blank.png", "blank.png", "blank.png", "blank.png", "blank.png"], ["blank.png", "blank.png", "blank.png", "blank.png", "blank.png", "blank.png"], ["blank.png", "blank.png", "blank.png", "blank.png", "blank.png", "blank.png"], ["blank.png", "blank.png", "blank.png", "blank.png", "blank.png", "blank.png"], ["blank.png", "blank.png", "blank.png", "blank.png", "blank.png", "blank.png"], ["blank.png", "blank.png", "blank.png", "blank.png", "blank.png", "blank.png"]],
      displayPositionsAlt: [["blank", "blank", "blank", "blank", "blank", "blank"], ["blank", "blank", "blank", "blank", "blank", "blank"], ["blank", "blank", "blank", "blank", "blank", "blank"], ["blank", "blank", "blank", "blank", "blank", "blank"], ["blank", "blank", "blank", "blank", "blank", "blank"], ["blank", "blank", "blank", "blank", "blank", "blank"], ["blank", "blank", "blank", "blank", "blank", "blank"]],
      // position values of 0/"", 1/X or 2/O indicating position empty, position taken by player 1 or position taken by player 2 respectively
      displayInputPositions: ["blank.png","blank.png","blank.png","blank.png","blank.png","blank.png","blank.png"],
      displayInputPositionsAlt: ["blank", "blank", "blank", "blank", "blank", "blank", "blank"]
    }
    this.handleMove = this.handleMove.bind(this);
  }

  handleMove(rowIndex) {
    if (this.state.currentStatus > 0) {
      let breakPoint = 0;
      let columnIndex = 0;
      this.state.positions[rowIndex].forEach(function(columnPosition) {
        if (columnPosition === 0) {
          if (breakPoint === 0) {
            breakPoint += 1;
            let currentPositions = this.state.positions;
            currentPositions[rowIndex][columnIndex] = this.state.currentPlayer;
            let currentDisplayPositions = this.state.displayPositions;
            currentDisplayPositions[rowIndex][columnIndex] = this.state.currentPlayerDisplay;
            let currentDisplayPositionsAlt = this.state.displayPositionsAlt;
            currentDisplayPositionsAlt[rowIndex][columnIndex] = this.state.currentPlayerDisplayAlt;
            this.setState({
              displayPositions: currentDisplayPositions,
              displayPositionsAlt: currentDisplayPositionsAlt,
              positions: currentPositions
            }, this.checkWin(rowIndex, columnIndex));
          }
        }
        columnIndex += 1;
      }.bind(this));
    }
  }

  changePlayer() {
    if (this.state.currentPlayer === 1) {
      this.setState({
        currentPlayer: 2,
        currentPlayerDisplay: "yellow_token.png",
        currentPlayerDisplayAlt: "yellow"
      });
    }
    else {
      this.setState({currentPlayer: 1,
        currentPlayerDisplay: "red_token.png",
        currentPlayerDisplayAlt: "red"
      });
    }
  }

  checkWin(rowIndex, columnIndex) {
    // check how many of same value left of position
      // does it equal 3? if so set winStatus = 1
    // check how many of same value right of position
      // does left + right equal 3? if so set winStatus = 1
    // repeat for down (no need for up because of gravity)
    // repeat for diag up-left and down-right
    // repeat for diag up-right and down-left
    // if winStatus = 1 end game
    // else change player
    let winStatus = 0;
    let left = 0;
    let right = 0;
    let down = 0;
    let upleft = 0;
    let downright = 0;
    let upright = 0;
    let downleft = 0;
    // check left
    for (let i = 1; i < 4; i++) {
      if (rowIndex - i >= 0) {
        if (this.state.positions[rowIndex - i][columnIndex] === this.state.currentPlayer) {
          left += 1;
        }
        else {
          break;
        }
      }
      else {
        break;
      }
      if (left === 3) {
        winStatus = 1;
      }
    }
    // check right
    for (let i = 1; i < 4; i++) {
      if (rowIndex + i <= 6) {
        if (this.state.positions[rowIndex + i][columnIndex] === this.state.currentPlayer) {
          right += 1;
        }
        else {
          break;
        }
      }
      else {
        break;
      }
      if (right === 3 || (right + left) === 3) {
        winStatus = 1;
      }
    }
    // check down
    for (let i = 1; i < 4; i++) {
      if (columnIndex - i >= 0) {
        if (this.state.positions[rowIndex][columnIndex - i] === this.state.currentPlayer) {
          down += 1;
        }
        else {
          break;
        }
      }
      else {
        break;
      }
      if (down === 3) {
        winStatus = 1;
      }
    }
    // check upleft
    for (let i = 1; i < 4; i++) {
      if (rowIndex - i >= 0 && columnIndex + i <= 5) {
        if (this.state.positions[rowIndex - i][columnIndex + i] === this.state.currentPlayer) {
          upleft += 1;
        }
        else {
          break;
        }
      }
      else {
        break;
      }
      if (upleft === 3) {
        winStatus = 1;
      }
    }
    // check downright
    for (let i = 1; i < 4; i++) {
      if (rowIndex + i <= 6 && columnIndex - i >= 0) {
        if (this.state.positions[rowIndex + i][columnIndex - i] === this.state.currentPlayer) {
          downright += 1;
        }
        else {
          break;
        }
      }
      else {
        break;
      }
      if (downright === 3 || (downright + upleft) === 3) {
        winStatus = 1;
      }
    }
    // check upright
    for (let i = 1; i < 4; i++) {
      if (rowIndex + i <= 6 && columnIndex + i <= 5) {
        if (this.state.positions[rowIndex + i][columnIndex + i] === this.state.currentPlayer) {
          upright += 1;
        }
        else {
          break;
        }
      }
      else {
        break;
      }
      if (upright === 3) {
        winStatus = 1;
      }
    }
    // check downleft
    for (let i = 1; i < 4; i++) {
      if (rowIndex - i >= 0 && columnIndex - i >= 0) {
        if (this.state.positions[rowIndex - i][columnIndex - i] === this.state.currentPlayer) {
          downleft += 1;
        }
        else {
          break;
        }
      }
      else {
        break;
      }
      if (downleft === 3 || (downleft + upright) === 3) {
        winStatus = 1;
      }
    }
    // make winStatus decision
    if (winStatus === 1) {
      const winningInputPositions = [this.state.currentPlayerDisplay, this.state.currentPlayerDisplay, this.state.currentPlayerDisplay, this.state.currentPlayerDisplay, this.state.currentPlayerDisplay, this.state.currentPlayerDisplay, this.state.currentPlayerDisplay];
      const winningInputPositionsAlt = [this.state.currentPlayerDisplayAlt, this.state.currentPlayerDisplayAlt, this.state.currentPlayerDisplayAlt, this.state.currentPlayerDisplayAlt, this.state.currentPlayerDisplayAlt, this.state.currentPlayerDisplayAlt, this.state.currentPlayerDisplayAlt];
      this.setState({
        currentStatus: 0,
        displayInputPositions: winningInputPositions,
        displayInputPositionsAlt: winningInputPositionsAlt
      })
    }
    else {
      this.changePlayer();
    }
  }

  render(){
    return(
      <div className="game-container">
        <Header
          title="Connect Four"
        />
        <PlayerDisplay
          currentPlayerDisplay={this.state.currentPlayerDisplay}
        />
        <BoardTable
          displayPositions={this.state.displayPositions}
          displayPositionsAlt={this.state.displayPositionsAlt}
          displayInputPositions={this.state.displayInputPositions}
          displayInputPositionsAlt={this.state.displayInputPositionsAlt}
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
