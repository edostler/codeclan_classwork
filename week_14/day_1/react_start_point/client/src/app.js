import React from 'react';
import ReactDOM from 'react-dom';

window.addEventListener('load', function () {
  const header = React.createElement("h1", null, "Hello World!");
  const appDiv = document.getElementById("app");
  ReactDOM.render(header, appDiv);
});
