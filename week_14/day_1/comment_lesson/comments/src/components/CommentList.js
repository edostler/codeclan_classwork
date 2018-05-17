import React, {Component} from "react";
import Comment from "./Comment";

class CommentList extends Component{

  render(){
    // return (
    //   <div className = "comment-list">
    //     <Comment author="Rick Henry">Cool</Comment>
    //     <Comment author="Jeff Bridges">The dude abides</Comment>
    //   </div>
    // );
    const commentNodes = this.props.data.map(comment => {
      return (
        <Comment author={comment.author} key={comment.id}>
          {comment.text}
        </Comment>
      );
    });
    return <div className="comment-list">{commentNodes}</div>
  }

}

export default CommentList;
