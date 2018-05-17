package Characters;

import Enums.Weapons;
import Interfaces.iAttack;

public abstract class Enemy implements iAttack {

    private String type;
    private int health;
    private int level;
    private Weapons weapon;

    public Enemy(String type, int health) {
        this.type = type;
        this.health = health;
        this.level = level;
        this.weapon = weapon;
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
