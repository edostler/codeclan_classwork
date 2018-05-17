import React from "react";
import './StatusDisplay.css';

const StatusDisplay = (props) => {
    if (props.currentStatus === 1) {
      return (
        <React.Fragment>
          <p className="status-display">Player {props.currentPlayer}'s Turn!</p>
          <p className="status-display-button" onClick={() => {window.location.reload()}}>Reset</p>
        </React.Fragment>
      )
    }
    else if (props.currentStatus === 0) {
      return(
        <React.Fragment>
          <p className="status-display">Player {props.currentPlayer} Wins!</p>
          <p className="status-display-button" onClick={() => {window.location.reload()}}>Play Again</p>
        </React.Fragment>
      )
    }
    else {
      return(
        <React.Fragment>
          <p className="status-display">It's A Draw!</p>
          <p className="status-display-button" onClick={() => {window.location.reload()}}>Play Again</p>
        </React.Fragment>
      )
    }
}

export default StatusDisplay;
