import React from "react";

const Terrier = (props) => {
  if(!props.terrier) return null;
  return (
    <React.Fragment>
      <h3>{props.terrier}</h3>
      <img src={props.terrierImage} alt=""/>
    </React.Fragment>
  )
}

export default Terrier;
