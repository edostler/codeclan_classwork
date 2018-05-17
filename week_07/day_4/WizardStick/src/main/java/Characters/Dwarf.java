package Characters;

import Interfaces.iAttack;

public class Dwarf extends Player  implements iAttack{

    public Dwarf(String name, String type, int health) {
        super(name, type, health);
    }

    @Override
    public String attack(Player player, Enemy enemy) {
        int power = player.calculateActualDamage();
        enemy.deductHealth(power);
        return player.getName() + " " + player.getWeapon().getAttack() + " the " + enemy.getType() + " with their " + player.getWeapon().toString().toLowerCase() + " inflicting a damage of " + power;
    }
}
