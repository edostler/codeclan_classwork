package Characters;

import Interfaces.iAttack;

public class Wizard extends Player implements iAttack {

    public Wizard(String name, String type, int health) {
        super(name, type, health);
    }

    @Override
    public String attack(Player player, Enemy enemy) {
        int power = player.calculateActualDamage();
        enemy.deductHealth(power);
        return player.getName() + " " + player.getWeapon().getAttack() + " the " + enemy.getType() + " with their " + player.getWeapon().toString().toLowerCase() + " inflicting a damage of " + power;
    }
}
