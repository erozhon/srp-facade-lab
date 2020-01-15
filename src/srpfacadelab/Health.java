package srpfacadelab;

public class Health {
    private int health;

    private int maxHealth;

    private int armour;

    public Health() {
        armour = 0;
        maxHealth = 2;
        health = 1;
    }

    public void calculateStats(Inventory inv) {
        for (Item i: inv.getInventory()) {
            armour += i.getArmour();
        }
    }

    public void takeDamage(int damage, IGameEngine gameEngine, Inventory inv) {
        if (damage < armour) {
            gameEngine.playSpecialEffect("parry");
        }
        if (inv.calculateInventoryWeight() < 0.5* inv.getCarryingCapacity()) {
            int damageToDeal = (int)(damage*0.75 - (double)armour);
            health -= damageToDeal;
        }
        else {
            int damageToDeal = damage - armour;
            health -= damageToDeal;
        }
        gameEngine.playSpecialEffect("lots_of_gore");
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }
}