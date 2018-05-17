package Enums;

public enum Spells {
    FIREBALL(15, "explodes"),
    LIGHTNINGSTRIKE(12, "electrifies"),
    FREEZEBREATH(12, "freezes");

    private int damage;
    private String attack;

    Spells(int damage, String attack) {
        this.damage = damage;
        this.attack = attack;
    }

    public int getDamage() {
        return damage;
    }

    public String getAttack() {
        return attack;
    }
}
