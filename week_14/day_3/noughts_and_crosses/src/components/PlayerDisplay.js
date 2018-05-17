import React from "react";
import './PlayerDisplay.css';

const PlayerDisplay = (props) => {
    return (
      <div className="player-display">
        <table className="player-display">
          <tbody>
            <tr>
              <td className="player-display">{props.currentPlayerDisplay}</td>
            </tr>
          </tbody>
        </table>
      </div>
    )
}

export default PlayerDisplay;
