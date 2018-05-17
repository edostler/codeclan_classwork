// const app = function(){
//   const tag = document.getElementById("intro");
//   tag.innerHTML = "I've changed the text";
//   console.log("Second Log");
// };
//
// console.log("First Log");
//
// window.onload = app;
//
// console.log("Third Log");
// // This above gives us 1st, 2nd 3rd log because onload does not happen straight away

const app = function(){
  const tag = document.getElementById("intro");
  debugger;
  tag.innerHTML = "I've changed the text";
};


window.onload = app;
