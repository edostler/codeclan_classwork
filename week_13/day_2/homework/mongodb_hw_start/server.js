const express = require('express');
const parser = require('body-parser');
const server = express();

server.use(parser.json());
server.use(express.static('client/build'));
server.use(parser.urlencoded({extended: true}));

const MongoClient = require("mongodb").MongoClient;
const ObjectID = require("mongodb").ObjectID;

MongoClient.connect("mongodb://localhost:27017", function(err, client){
  if(err){
    console.log(err);
    return;
  }
  const db = client.db("homework-test");
  console.log("Connected to database");

  server.post("/api/homework", function(req, res){
    const homeworkCollection = db.collection("homework");
    const homeworkToSave = req.body;
    homeworkCollection.save(homeworkToSave, function(err, result){
      if(err){
        console.log(err);
        res.status(500);
        res.send();
      }
      console.log("Homework saved!");
      res.status(201);
      res.json(homeworkToSave);
    });
  });

  server.get("/api/homework", function(req, res){
    const homeworkCollection = db.collection("homework");
    homeworkCollection.find().toArray(function(err, allHomework){
      if(err){
        console.log(err);
        res.status(500);
        res.send();
      }
      res.json(allHomework);
    });
  });

  server.delete("/api/homework", function(req, res){
    const homeworkCollection = db.collection("homework");
    const filterObject = {};
    homeworkCollection.deleteMany(filterObject, function(err, result){
      if(err){
        console.log(err);
        res.status(500);
        res.send();
      }
      console.log("Homework deleted!");
      res.status(204);
      res.send();
    });
  });

  server.put("/api/homework/:id", function(req, res){
    const homeworkCollection = db.collection("homework");
    const objectID = ObjectID(req.params.id);
    const filterObject = {_id: objectID};
    const updatedData = req.body;
    homeworkCollection.update(filterObject, updatedData, function(err, result){
      if(err){
        console.log(err);
        res.status(500);
        res.send();
      }
      console.log("Homework updated!");
      res.status(204);
      res.send();
    });
  });

  server.listen(3000, function(){
    console.log("Listening on port 3000");
  });
});
