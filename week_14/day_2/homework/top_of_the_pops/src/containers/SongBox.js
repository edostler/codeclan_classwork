import React, {Component} from "react";
import SongTable from "../components/SongTable";
import Header from '../components/Header';
import './SongBox.css';

class SongBox extends Component{

  constructor(props){
    super(props)
    this.state = {
      songs: [],
    }
  }

  componentDidMount(){
    fetch("https://itunes.apple.com/gb/rss/topsongs/limit=20/json")
      .then(response => response.json())
      .then(json => this.setState({songs: json.feed.entry}));
  }

  render(){
    return(
      <div className="song-box">
        <Header title="UK Top 20"/>
        <SongTable songs={this.state.songs}/>
      </div>
    );
  }

}

export default SongBox;
