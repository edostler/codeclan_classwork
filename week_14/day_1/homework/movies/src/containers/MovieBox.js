import React, {Component} from "react";
import '../App.css';
import MovieList from "../components/MovieList.js";

class MovieBox extends Component {

  constructor(props){
    super(props);
    this.state = {
      data: [
        {
          id: 1, title: "Batman Returns", times: ["19:05", ", ", "22:40"]
        },
        {
          id:2, title: "RoboCop", times: ["13.50", ", ", "17:40"]
        },
        {
          id:3, title: "Aliens", times: ["21.45", ", ", "14:25"]
        },
        {
          id:4, title: "Terminator 2: Judegment Day", times: ["18.25", ", ", "19:10"]
        },
        {
          id:5, title: "Gremlins 2", times: ["15.15", ", ", "18:55"]
        },
      ]
    }
  }

  render(){
    return (
      <div className="movie-box">
        <h2>Movie List</h2>
        <MovieList data={this.state.data}/>
      </div>)
  }

}

export default MovieBox;
