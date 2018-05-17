const app = function(){
  const button = document.querySelector("button");
  button.addEventListener("click", handleButtonClick);

  const input = document.querySelector("input");
  input.addEventListener("keyup", handleKeyPress);

  const select = document.querySelector("select");
  select.addEventListener("change", handleSelectChange);
}

let clickCount = 0;

const handleButtonClick = function(event){
  const pTag = document.querySelector("#button-result");
  clickCount += 1;
  pTag.innerText = "Wow dude, I got totally clicked!" + " " + clickCount + " times!";
  console.log(event);
}

const handleKeyPress = function(event){
  const pTag = document.querySelector("#text-result");
  pTag.innerText = this.value;
  console.log(event);
}

const handleSelectChange = function(event){
  const pTag = document.querySelector("#select-result");
  pTag.innerText = this.value;
  console.log(event);
}

window.addEventListener('load', app);
