var express = require("express");
var app = express();

app.get("/", function(req, res){
  res.sendFile(__dirname + "/index.html");
})

var jsonData = {name: "Saturn", size: 90876}

app.get("/data", function(req, res){
  res.json(jsonData);
})

app.use(express.static("public"));

app.listen(3000, function(){
  console.log("App running on port " + this.address().port);
})
