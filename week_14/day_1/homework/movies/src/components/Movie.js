import React from "react";
import '../App.css';

const Movie = (props) => (
  <div className="movie">
    <h4 className="movie-title">{props.title}</h4>
    <p>{props.children}</p>
  </div>
)

export default Movie;
