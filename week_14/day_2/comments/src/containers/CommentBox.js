import React, { Component } from "react";
import CommentList from "../components/CommentList";
import CommentForm from "../components/CommentForm";

class CommentBox extends Component {

  constructor(props){
    super(props);
    this.handleCommentSubmit = this.handleCommentSubmit.bind(this);
    this.state = {
      data: [{ id: 1, author: "Jean", text: "Socks don't have to match to smile"},
    { id:2, author: "BA Baracus", text: "I pity the fool"}]
    };
  }

  handleCommentSubmit(comment){
    comment.id = Date.now();
    const newComments = this.state.data.concat([comment]);
    this.setState({data: newComments});
  }

  render(){
    return (
      <div className="comment-box">
        <h1>Comments</h1>
        <CommentForm onCommentSubmit={this.handleCommentSubmit}/>
        <h2>Comment List</h2>
        <CommentList data={this.state.data} />
      </div>
    );
  }

}

export default CommentBox;
