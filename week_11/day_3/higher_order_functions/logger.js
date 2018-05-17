const logRed = function(message){
  console.log(message);
};

const logNotRed = function(){
  console.log("It's NOT red!");
};

const redChecker = function(message, colour, isRed, isNotRed){
  if (colour === "red") {
    isRed(message);
  }
  else {
    isNotRed();
  }
  console.log("Done!");
};

redChecker("This will print out when colour is red", "red", logRed, logNotRed);
