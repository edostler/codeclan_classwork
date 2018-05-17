package Enums;

public enum HealingTools {
    POTION(10, "revives"),
    HERBS(5, "does fuck all, but placebo affects"),
    INCANTATION(15, "charms");

    private int restore;
    private String heals;

    HealingTools(int restore, String heals) {
        this.restore = restore;
        this.heals = heals;
    }

    public int getRestore() {
        return restore;
    }

    public String getHeals() {
        return heals;
    }
}
