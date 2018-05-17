package Characters;

public class Ogre extends Enemy {

    public Ogre(String type, int health) {
        super(type, health);
    }

    @Override
    public String attack(Player player, Enemy enemy) {
        int power = enemy.calculateActualDamage();
        player.deductHealth(power);
        return enemy.getType() + " " + enemy.getWeapon().getAttack() + " " + player.getName() + " with their " + enemy.getWeapon().toString().toLowerCase() + " inflicting a damage of " + power;
    }
}
