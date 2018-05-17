package Enums;

public enum Creatures {
    UNICORN(10, "charges"),
    DRAGON(15, "incinerates"),
    HYDRA(18, "poisons");

private int damage;
private String attack;

    Creatures(int damage, String attack) {
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
