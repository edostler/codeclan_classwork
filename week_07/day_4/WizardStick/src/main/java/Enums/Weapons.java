package Enums;

public enum Weapons {
    SWORD(10, "slashes"),
    AXE(8, "sleaves"),
    CLUB(5, "bludgeons");

    private int damage;
    private String attack;

    Weapons(int damage, String attack){
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


