var assert = require('assert')
var Hero = require('../hero.js')
var Task = require('../task.js')
var Food = require('../food.js')
var Rat = require('../rat.js')

describe("Hero", function(){
  beforeEach(function(){
    hero1 = new Hero("Ed", "Steak");
    task1 = new Task(8, 10, 500);
    task2 = new Task(5, 3, 300);
    task3 = new Task(7, 2, 350);
    food1 = new Food("Chicken", 60);
    food2 = new Food("Steak", 60);
    rat1 = new Rat();
  });
  it("Has a name", function(){
    assert.strictEqual(hero1.name, "Ed");
  });
  it("Has health 100 at start", function(){
    assert.strictEqual(hero1.health, 100);
  });
  it("Has a favourite food", function(){
    assert.strictEqual(hero1.favouriteFood, "Steak");
  });
  it("Can talk", function(){
    assert.strictEqual(hero1.talk(), "Hi, I'm Ed");
  });
  it("Hero has an array of tasks that starts empty", function(){
    assert.deepStrictEqual(hero1.tasks, []);
  });
  it("Can add a task to heros tasks", function(){
    hero1.add(task1)
    assert.deepStrictEqual(hero1.tasks, [task1]);
  });
  it("Can change health by passed in value", function(){
    hero1.changeHealth(10);
    assert.deepStrictEqual(hero1.health, 110);
  });
  it("Can eat food to increase health by replenishment value - normal food", function(){
    hero1.eat(food1);
    assert.deepStrictEqual(hero1.health, 160);
  });
  it("Can eat food to increase health by replenishment value - fave food", function(){
    hero1.eat(food2);
    assert.deepStrictEqual(hero1.health, 190);
  });
  it("Get taks sorted by difficulty", function(){
    hero1.add(task1)
    hero1.add(task2)
    hero1.add(task3)
    assert.deepStrictEqual(hero1.sortTasks("difficulty"), [task2, task3, task1]);
  });
  it("Get taks sorted by urgency", function(){
    hero1.add(task1)
    hero1.add(task2)
    hero1.add(task3)
    assert.deepStrictEqual(hero1.sortTasks("urgency"), [task3, task2, task1]);
  });
  it("Get taks sorted by reward", function(){
    hero1.add(task1)
    hero1.add(task2)
    hero1.add(task3)
    assert.deepStrictEqual(hero1.sortTasks("reward"), [task2, task3, task1]);
  });
  it("Can complete a task", function(){
    hero1.completeTask(task1)
    assert.deepStrictEqual(task1.status, true);
  });
  it("Get completed tasks", function(){
    hero1.add(task1)
    hero1.add(task2)
    hero1.add(task3)
    hero1.completeTask(task1);
    hero1.completeTask(task3);
    assert.deepStrictEqual(hero1.getCompletedTasks(), [task1, task3]);
  });
  it("Get incomplete tasks", function(){
    hero1.add(task1)
    hero1.add(task2)
    hero1.add(task3)
    hero1.completeTask(task1);
    hero1.completeTask(task3);
    assert.deepStrictEqual(hero1.getIncompleteTasks(), [task2]);
  });
  it("Can eat poisoned food to decrease health by 50", function(){
    food1.poison();
    hero1.eat(food1);
    assert.deepStrictEqual(hero1.health, 50);
  });
  it("Has a dead status that starts false", function(){
    assert.strictEqual(hero1.dead, false);
  });
  it("Can set dead status to true", function(){
    hero1.die();
    assert.strictEqual(hero1.dead, true);
  });
  it("Hero can die if health reaches 0", function(){
    hero1.changeHealth(-105)
    assert.deepStrictEqual(hero1.health, 0);
    assert.deepStrictEqual(hero1.dead, true);
  });
  it("Hero can stomp rat for value of 30", function(){
    hero1.stomp(rat1)
    assert.deepStrictEqual(rat1.health, 0);
    assert.deepStrictEqual(rat1.dead, true);
  });

});
