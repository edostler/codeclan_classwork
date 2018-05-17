import React from "react";
import './BoardTable.css';

const BoardTable = (props) => {
  return (
    <div className="table-div">
      <table>
        <tbody>
          <tr>
            <td id="position0" onClick={() => {props.handleMove(0)}}>{props.displayPositions[0]}</td>
            <td id="position1" onClick={() => {props.handleMove(1)}}>{props.displayPositions[1]}</td>
            <td id="position2" onClick={() => {props.handleMove(2)}}>{props.displayPositions[2]}</td>
          </tr>
          <tr>
            <td id="position3" onClick={() => {props.handleMove(3)}}>{props.displayPositions[3]}</td>
            <td id="position4" onClick={() => {props.handleMove(4)}}>{props.displayPositions[4]}</td>
            <td id="position5" onClick={() => {props.handleMove(5)}}>{props.displayPositions[5]}</td>
          </tr>
          <tr>
            <td id="position6" onClick={() => {props.handleMove(6)}}>{props.displayPositions[6]}</td>
            <td id="position7" onClick={() => {props.handleMove(7)}}>{props.displayPositions[7]}</td>
            <td id="position8" onClick={() => {props.handleMove(8)}}>{props.displayPositions[8]}</td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default BoardTable;
