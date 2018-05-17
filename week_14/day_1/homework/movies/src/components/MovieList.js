// import React from "react";
// import Movie from "./Movie.js";
//
// const MovieList = (props) => (
//   const movieNodes = props.data.map(movie => {
//     return (
//       <Movie title={movie.title} key={movie.id}>
//         {movie.times}
//       </Movie>
//     );
//   });
//   <div className="movie-list">{movieNodes}</div>
// )
//
// export default MovieList;


import React, {Component} from "react";
import '../App.css';
import Movie from "./Movie";

class MovieList extends Component{

  render(){
    const movieNodes = this.props.data.map(movie => {
      return (
        <Movie title={movie.title} key={movie.id}>
          {movie.times}
        </Movie>
      );
    });
    return <div className="movie-list">{movieNodes}</div>
  }

}

export default MovieList;
