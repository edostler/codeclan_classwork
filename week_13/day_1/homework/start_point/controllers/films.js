//since we don't have a database we'll use our front end models at the moment
var films = require('../client/src/models/films')();
var Film = require('../client/src/models/film');
var Review = require('../client/src/models/review');

var express = require('express');
var filmRouter = new express.Router();

filmRouter.get('/:id', function(req, res) {
  res.json(films[req.params.id]);
});

filmRouter.get('/', function(req, res) {
  // debugger;
  res.json(films);
});

filmRouter.post("/", function(req, res) {
  const filmToAdd = new Film({
    title: req.body.title,
    actors: req.body.actors,
    genre: req.body.genre
  });
  films.push(filmToAdd);
  res.json(films);
});

filmRouter.put("/:id", function(req, res) {
  const filmToAdd = new Film({
    title: req.body.title,
    actors: req.body.actors,
    genre: req.body.genre
  });
  films[req.params.id] = filmToAdd;
  res.json(films);
})

filmRouter.delete("/:id", function(req, res) {
  films.splice(req.params.id, 1);
  res.json(films);
})

module.exports = filmRouter;
