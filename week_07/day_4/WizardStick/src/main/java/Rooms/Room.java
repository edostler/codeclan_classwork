package Rooms;

import Characters.Enemy;
import Treasures.Treasure;

public class Room {

    String roomname;
    int roonnum;
    Enemy enemy;
    Treasure treasure;

    public Room(String roomname, int roonnum, Enemy enemy, Treasure treasure) {
        this.roomname = roomname;
        this.roonnum = roonnum;
        this.enemy = enemy;
        this.treasure = treasure;
    }

    public String getRoomname() {
        return roomname;
    }

    public int getRoonnum() {
        return roonnum;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public String describeRoom(){
        return "You enter the " + this.roomname + ". Suddenly, a belligerent and bloodthirsty " + this.enemy.getType() + " appears, wielding a deadly " + enemy.getWeapon().toString().toLowerCase() + ", and guarding a huge chest of " + this.treasure.getType();
    }
}