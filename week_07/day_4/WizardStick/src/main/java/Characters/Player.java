package Characters;

import Enums.Weapons;
import Interfaces.iAttack;

public abstract class Player {

    private String name;
    private String type;
    private int health;
    private int level;
    private Weapons weapon;

    public Player(String name, String type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.level = level;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public void deductHealth(int damage) {
        this.health -= damage;
    }

    public int calculateActualDamage() {
        int actual = this.weapon.getDamage() * this.level;
        return actual;
    }
}
