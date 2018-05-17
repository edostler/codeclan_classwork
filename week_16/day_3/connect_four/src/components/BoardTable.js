import React from "react";
import './BoardTable.css';

const BoardTable = (props) => {
  return (
    <div className="table-div">
      <table className="board-input">
        <tbody>
          <tr>
            <td className="board-input-position" onClick={() => {props.handleMove(0)}}><img src={props.displayInputPositions[0]} alt={props.displayInputPositionsAlt[0]}></img></td>
            <td className="board-input-position" onClick={() => {props.handleMove(1)}}><img src={props.displayInputPositions[1]} alt={props.displayInputPositionsAlt[1]}></img></td>
            <td className="board-input-position" onClick={() => {props.handleMove(2)}}><img src={props.displayInputPositions[2]} alt={props.displayInputPositionsAlt[2]}></img></td>
            <td className="board-input-position" onClick={() => {props.handleMove(3)}}><img src={props.displayInputPositions[3]} alt={props.displayInputPositionsAlt[3]}></img></td>
            <td className="board-input-position" onClick={() => {props.handleMove(4)}}><img src={props.displayInputPositions[4]} alt={props.displayInputPositionsAlt[4]}></img></td>
            <td className="board-input-position" onClick={() => {props.handleMove(5)}}><img src={props.displayInputPositions[5]} alt={props.displayInputPositionsAlt[5]}></img></td>
            <td className="board-input-position" onClick={() => {props.handleMove(6)}}><img src={props.displayInputPositions[6]} alt={props.displayInputPositionsAlt[6]}></img></td>
          </tr>
        </tbody>
      </table>
      <table className="board">
        <tbody>
          <tr>
            <td className="light"><img src={props.displayPositions[0][5]} alt={props.displayPositionsAlt[0][5]}></img></td>
            <td className="dark"><img src={props.displayPositions[1][5]} alt={props.displayPositionsAlt[1][5]}></img></td>
            <td className="light"><img src={props.displayPositions[2][5]} alt={props.displayPositionsAlt[2][5]}></img></td>
            <td className="dark"><img src={props.displayPositions[3][5]} alt={props.displayPositionsAlt[3][5]}></img></td>
            <td className="light"><img src={props.displayPositions[4][5]} alt={props.displayPositionsAlt[4][5]}></img></td>
            <td className="dark"><img src={props.displayPositions[5][5]} alt={props.displayPositionsAlt[5][5]}></img></td>
            <td className="light"><img src={props.displayPositions[6][5]} alt={props.displayPositionsAlt[6][5]}></img></td>
          </tr>
          <tr>
            <td className="dark"><img src={props.displayPositions[0][4]} alt={props.displayPositionsAlt[0][4]}></img></td>
            <td className="light"><img src={props.displayPositions[1][4]} alt={props.displayPositionsAlt[1][4]}></img></td>
            <td className="dark"><img src={props.displayPositions[2][4]} alt={props.displayPositionsAlt[2][4]}></img></td>
            <td className="light"><img src={props.displayPositions[3][4]} alt={props.displayPositionsAlt[3][4]}></img></td>
            <td className="dark"><img src={props.displayPositions[4][4]} alt={props.displayPositionsAlt[4][4]}></img></td>
            <td className="light"><img src={props.displayPositions[5][4]} alt={props.displayPositionsAlt[5][4]}></img></td>
            <td className="dark"><img src={props.displayPositions[6][4]} alt={props.displayPositionsAlt[6][4]}></img></td>
          </tr>
          <tr>
            <td className="light"><img src={props.displayPositions[0][3]} alt={props.displayPositionsAlt[0][3]}></img></td>
            <td className="dark"><img src={props.displayPositions[1][3]} alt={props.displayPositionsAlt[1][3]}></img></td>
            <td className="light"><img src={props.displayPositions[2][3]} alt={props.displayPositionsAlt[2][3]}></img></td>
            <td className="dark"><img src={props.displayPositions[3][3]} alt={props.displayPositionsAlt[3][3]}></img></td>
            <td className="light"><img src={props.displayPositions[4][3]} alt={props.displayPositionsAlt[4][3]}></img></td>
            <td className="dark"><img src={props.displayPositions[5][3]} alt={props.displayPositionsAlt[5][3]}></img></td>
            <td className="light"><img src={props.displayPositions[6][3]} alt={props.displayPositionsAlt[6][3]}></img></td>
          </tr>
          <tr>
            <td className="dark"><img src={props.displayPositions[0][2]} alt={props.displayPositionsAlt[0][2]}></img></td>
            <td className="light"><img src={props.displayPositions[1][2]} alt={props.displayPositionsAlt[1][2]}></img></td>
            <td className="dark"><img src={props.displayPositions[2][2]} alt={props.displayPositionsAlt[2][2]}></img></td>
            <td className="light"><img src={props.displayPositions[3][2]} alt={props.displayPositionsAlt[3][2]}></img></td>
            <td className="dark"><img src={props.displayPositions[4][2]} alt={props.displayPositionsAlt[4][2]}></img></td>
            <td className="light"><img src={props.displayPositions[5][2]} alt={props.displayPositionsAlt[5][2]}></img></td>
            <td className="dark"><img src={props.displayPositions[6][2]} alt={props.displayPositionsAlt[6][2]}></img></td>
          </tr>
          <tr>
            <td className="light"><img src={props.displayPositions[0][1]} alt={props.displayPositionsAlt[0][1]}></img></td>
            <td className="dark"><img src={props.displayPositions[1][1]} alt={props.displayPositionsAlt[1][1]}></img></td>
            <td className="light"><img src={props.displayPositions[2][1]} alt={props.displayPositionsAlt[2][1]}></img></td>
            <td className="dark"><img src={props.displayPositions[3][1]} alt={props.displayPositionsAlt[3][1]}></img></td>
            <td className="light"><img src={props.displayPositions[4][1]} alt={props.displayPositionsAlt[4][1]}></img></td>
            <td className="dark"><img src={props.displayPositions[5][1]} alt={props.displayPositionsAlt[5][1]}></img></td>
            <td className="light"><img src={props.displayPositions[6][1]} alt={props.displayPositionsAlt[6][1]}></img></td>
          </tr>
          <tr>
            <td className="dark"><img src={props.displayPositions[0][0]} alt={props.displayPositionsAlt[0][0]}></img></td>
            <td className="light"><img src={props.displayPositions[1][0]} alt={props.displayPositionsAlt[1][0]}></img></td>
            <td className="dark"><img src={props.displayPositions[2][0]} alt={props.displayPositionsAlt[2][0]}></img></td>
            <td className="light"><img src={props.displayPositions[3][0]} alt={props.displayPositionsAlt[3][0]}></img></td>
            <td className="dark"><img src={props.displayPositions[4][0]} alt={props.displayPositionsAlt[4][0]}></img></td>
            <td className="light"><img src={props.displayPositions[5][0]} alt={props.displayPositionsAlt[5][0]}></img></td>
            <td className="dark"><img src={props.displayPositions[6][0]} alt={props.displayPositionsAlt[6][0]}></img></td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default BoardTable;
