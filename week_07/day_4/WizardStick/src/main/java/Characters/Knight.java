package Characters;

import Interfaces.iAttack;

public class Knight extends Player implements iAttack {

    private int armour;

    public Knight(String name, String type, int health, int armour) {
        super(name, type, health);
        this.armour = armour;
    }

    public int getArmour() {
        return armour;
    }

    @Override
    public String attack(Player player, Enemy enemy) {
        int power = player.calculateActualDamage();
        enemy.deductHealth(power);
        return player.getName() + " " + player.getWeapon().getAttack() + " the " + enemy.getType() + " with their " + player.getWeapon().toString().toLowerCase() + " inflicting a damage of " + power;
    }
}
