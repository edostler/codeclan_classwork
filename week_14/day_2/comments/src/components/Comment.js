import React from "react";

const Comment = (props) =>
  <div className="comment">
    <h4 className="commentAuthor">{props.author}</h4>
  {props.children}
  </div>

export default Comment;
