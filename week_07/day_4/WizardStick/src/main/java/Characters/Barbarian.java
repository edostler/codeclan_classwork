package Characters;

import Enums.Weapons;
import Interfaces.iAttack;

public class Barbarian extends Player implements iAttack {

    int strength;

    public Barbarian(String name, String type, int health, int strength) {
        super(name, type, health);
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String attack(Player player, Enemy enemy) {
        Barbarian barbarian = (Barbarian) player;
        int power = player.calculateActualDamage() * barbarian.getStrength();
        enemy.deductHealth(power);
        return player.getName() + " " + player.getWeapon().getAttack() + " the " + enemy.getType() + " with their " + player.getWeapon().toString().toLowerCase() + " inflicting a damage of " + power;
    }
}
