window.addEventListener("DOMContentLoaded", function(){
  const canvas = document.getElementById("main-canvas");
  const context = canvas.getContext("2d");

  // drawing a rectangle
  context.fillStyle = "green";
  context.strokeStyle = "blue";
  context.strokeRect(0, 0, 50, 50);

  // drawing a line
  context.beginPath();
  context.moveTo(100, 100);
  context.lineTo(100, 200);
  context.stroke();

  // drawing a triangle
  context.beginPath();
  context.moveTo(200, 200);
  context.lineTo(200, 300);
  context.lineTo(100, 300);
  context.closePath();
  // close path takes the direct route back to the moveTo coords
  context.fill();

  // drawing a circle
  context.beginPath();
  context.arc(275, 75, 50, 0, Math.PI * 2, true);
  context.stroke();
  context.fillStyle = "green";
  context.beginPath();
  context.arc(275, 75, 49, 0, Math.PI * 2, true);
  context.fill();

  const drawCircle = function(x, y){
    context.beginPath();
    context.arc(x, y, 10, 0, Math.PI * 2, true);
    context.stroke();
  }

  canvas.addEventListener("mousemove", function(event){
    // console.log("locatation", event.x, event.y);
    drawCircle(event.x, event.y);
  })

  const img = document.createElement("img");
  img.src = "https://pbs.twimg.com/profile_images/788554727378325505/8lzc7jXx_reasonably_small.jpg"

  const drawJeff = function(){
    context.drawImage(img, 200, 200, 50, 50);
  }
  const drawImg = function(x, y){
    context.drawImage(img, x, y, 500, 500);
  }

  img.addEventListener("load", drawJeff);

  // canvas.addEventListener("mousemove", function(event){
  //   drawImg(event.x, event.y);
  // })

  const changeColor = function(){
    context.strokeStyle = this.value;
  }

  const colorPicker = document.getElementById("input-color");
  colorPicker.addEventListener("change", changeColor);



})
