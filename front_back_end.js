Back end/API Setup:

0. node js
0. npm init -> package.json
0. npm install -> node_modules
0. .gitignore (node_modules, bundle.js, bundle.js.map, npm-debug.log)

1. npm install express (production)
2. npm install mongodb (production)
3. npm install body-parser (production)
4. npm install mocha --save-dev (development)
5. npm install nodemon --save-dev (development)

BOTH: npm install lodash (production)(require it in for back end, front end was <script src='index.js'></script>
<script src="https://cdn.jsdelivr.net/npm/lodash@4.17.5/lodash.min.js"></script> prior to webpack, now it just needs requiring in)

Front end Setup:
1. npm install webpack (development) (requireJS, browserify, gulp, grunt - these are all alternatives)

Scripts:
1. "test": point to mocha (e.g. "mocha client/src/models/specs") -> npm test
2. "start": "node server.js" (production), "nodemon server.js" (development), "nodemon --inspect server" -> npm start
3. "build"/"webpack": "cd client && webpack -w" -> npm run build/webpack
4. "deploy": "" -> npm run deploy (seen in the wild)

Terminal Windows:
1. mongod
2. npm start (server)
3. npm run build (webpack)
4. mongo
5. for fun (regular terminal stuff)



Example of a project setup (see Johns Coffee App):

[TERMINAL.5, INITIAL SETUP]
    mkdir example_app
    cd example_app
    npm init -y
    npm install express mongodb body-parser
    npm install nodemon --save-dev
    [ALSO MOCHA IF TESTING, LODASH IF NEEDED, REMEMBER GIT INIT AND .GITIGNORE]
    touch server.js

[OPEN SERVER.JS IN ATOM]
    const express = require('express');
    const bodyParser = require('body-parser');
    const server = express();
    const path = require("path");
    [SERVER CAN ALSO BE CALLED APP; PATH IS INSTALLED WITH NODE]

    server.use(bodyParser.json());
    server.use(bodyParser.urlencoded({extended: true}));
    server.use(express.static('client/build'));

    const MongoClient = require("mongodb").MongoClient;
    const ObjectID = require("mongodb").ObjectID;

    MongoClient.connect("mongodb://localhost:27017", function(err, client){
      if(err){
        console.log(err);
        return;
      }
      const db = client.db("example_database_name");
      console.log("Connected to database");

      server.get("/api/examples", function(req, res){
        const examplesCollection = db.collection("examples");
        examplesCollection.find().toArray(function(err, allExamples){
          if(err){
            console.log(err);
            res.status(500);
            res.send();
          }
          res.json(allExamples);
        });
      });

      server.post("/api/examples", function(req, res){
        const examplesCollection = db.collection("examples");
        const exampleToSave = req.body;
        examplesCollection.save(exampleToSave, function(err, result){
          if(err){
            console.log(err);
            res.status(500);
            res.send();
          }
          res.status(201);
          res.json(exampleToSave);
        });
      });

      server.delete("/api/examples", function(req, res){
        const examplesCollection = db.collection("examples");
        const filterObject = {};
        examplesCollection.deleteMany(filterObject, function(err, result){
          if(err){
            console.log(err);
            res.status(500);
            res.send();
          }
          res.status(204);
          res.send();
        });
      });

      server.put("/api/examples/:id", function(req, res){
        const examplesCollection = db.collection("examples");
        const objectID = ObjectID(req.params.id);
        const filterObject = {_id: objectID};
        const updatedData = req.body;
        examplesCollection.update(filterObject, updatedData, function(err, result){
          if(err){
            console.log(err);
            res.status(500);
            res.send();
          }
          res.status(204);
          res.send();
        });
      });

      server.listen(3000, function(){
        console.log("Listening on port 3000");
      });
    });

[GO TO PACKAGE.JSON, ADD SCRIPT]
    "start": "nodemon server.js",

[TERMINAL.1, START MONGO]
    mongod -v

[TERMINAL.2, START SERVER]
    npm start

[SEED DATABASE - CAN DO IN MONGO OR A SEPARATE FILE - WOULD CREATE A DB FOLDER IN MAIN AND IN THERE A SEEDS.JS WHERE WE CAN USE MONGO TO WRITE ANY DATA THEN IN TERMINAL: MONGO < DB/SEEDS.JS]

[USING MONGO, TERMINAL.4, OPEN MONGO]
    mongo
    show dbs
    [IF EXAMPLE_DATABASE_NAME DOESNT EXIST HERE CREATE IT OR OPEN IT USING]
    use example_database_name
    db.example_database_name.insert({stringField1: "string1", stringField2: "string2", intField1: 1})

[CAN NOW CHECK " http://localhost:3000/examples " TO SEE STUFF WORKING, SHOULD HAVE EXAMPLE DATA ENTRY]

[TERMINAL.1, FRONT-END SETUP]
    mkdir client
    npm install webpack@3.11.0 --save-dev
    mkdir client/build
    mkdir client/src
    touch client/webpack.config.js
    touch client/src/app.js

[OPEN WEBPACK.CONFIG.JS]
    const config = {
      entry: __dirname + "/src/app.js",
      output: {
        filename: "bundle.js",
        path: __dirname + "/build"
      },
      devtool: 'source-map'
    }
    module.exports = config;

[OPEN APP.JS]
    document.addEventListener("DOMContentLoaded", function(){
      console.log("Webpack is working");
    });
    [THIS IS JUST A TEMPORARY SO CHECK WORKING]

[GO TO PACKAGE.JSON, ADD SCRIPT]
    "build": "cd client && webpack -w",

[TERMINAL.3, START WEBPACK]
    npm run build

[TERMINAL.1]
    touch client/build/index.html

[OPEN INDEX.HTML]
    !<+TAB>
    [TO SETUP HTML FILE QUICKLY]
    <script src="bundle.js"></script>
    [THIS IS IN <head>]

[CHECK THIS IS WORKING GO TO " http://localhost:3000/examples " AND VIEW SOURCE TO SEE THAT HTML IS THERE]

[IN REAL WORLD WE WANT TO SEPARATE STRUCTURE OUT, SEE STAR-WARS EXAMPLE WITH SERVICES/REQUEST.JS AND VIEWS]

[OPEN APP.JS]
    const makeRequest = function(url, callback){
      const request = new XMLHttpRequest();
      request.open("GET", url);
      request.addEventListener("load", callback);
      request.send();
    };

    const examplesRequestComplete = function(){
      const responseText = this.responseText;
      const exampleArray = JSON.parse(responseText);
      populateList(exampleArray);
    };

    const populateList = function(exampleArray){
      for(let example of exampleArray){
        const newPTag = document.createElement("p");
        newPTag.innerText = "This is: ${example.stringField1} with has a value of ${example.intField1}.";
        document.body.appendChild(newPTag);
      }
    };

    const app = function(){
      makeRequest("/examples", examplesRequestComplete)
    };

    document.addEventListener("DOMContentLoaded", app);
    });
    [THIS IS NOW A BASIC WORKING EXAMPLE OF A FULLSTACK APP]
