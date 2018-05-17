import React from "react";
import './PlayerDisplay.css';

const PlayerDisplay = (props) => {
  return (
    <div className="player-display">
      <table className="player-display">
        <tbody>
          <tr>
            <td className="player-display"><img src={props.currentPlayerDisplay} alt={props.currentPlayerDisplayAlt}></img></td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default PlayerDisplay;
