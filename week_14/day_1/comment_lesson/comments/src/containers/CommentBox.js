import React, {Component} from "react";
import CommentList from "../components/CommentList";

class CommentBox extends Component{

  constructor(props){
    super(props);
    this.state = {
      data: [
        {
          id: 1, author: "Jean", text: "Socks don't have to match to smile"
        },
        {
          id: 2, author: "BA Baracus", text: "I pity the fool"
        }
      ]
    };
  }

  render(){
    return (
      <div className = "comment-box">
        <h2>Comment List</h2>
        <CommentList data={this.state.data}/>
      </div>
    );
  }

}

export default CommentBox;
