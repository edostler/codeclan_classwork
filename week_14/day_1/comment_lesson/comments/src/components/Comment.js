// import React, {Component} from "react";
//
// class Comment extends Component{
//
//   render(){
//     return(
//       <div className="comment">
//         <h4 className="comment-author">{this.props.author}</h4>
//         <p>{this.props.children}</p>
//       </div>
//     );
//   }
//
// }
//
// export default Comment;


import React from "react";

const Comment = (props) => (
  <div className="comment">
    <h4 className="comment-author">{props.author}</h4>
    <p>{props.children}</p>
  </div>
);

export default Comment;
