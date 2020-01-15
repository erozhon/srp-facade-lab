package srpfacadelab;

public class Facade {
    private Inventory inventoryClass;
    private Health healthClass;

    public Facade() {
        inventoryClass = new Inventory();
        healthClass = new Health();
    }
    public void AddToInventory(Item item) {
        inventoryClass.AddToInventory(item);
    }
    public boolean checkIfItemExistsInInventory(Item item) {
        return inventoryClass.checkIfItemExistsInInventory(item);
    }
    public int calculateInventoryWeight() {
        return inventoryClass.calculateInventoryWeight();
    }
    public int getCarryingCapacity() {
        return inventoryClass.getCarryingCapacity();
    }
    public void setCarryingCapacity(int carryingCapacity) {
        inventoryClass.setCarryingCapacity(carryingCapacity);
    }
    public void calculateStats(Inventory inventoryClass) {
        healthClass.calculateStats(inventoryClass);
    }
    public void takeDamage(int damage, IGameEngine gameEngine, Inventory inventoryClass) {
        healthClass.takeDamage(damage, gameEngine, inventoryClass);
    }
    public Inventory getInventory() {
        return inventoryClass;
    }
    public int getHealth() {
        return healthClass.getHealth();
    }
    public void setHealth(int health) {
        healthClass.setHealth(health);
    }
    public int getMaxHealth() {
       return healthClass.getMaxHealth();
    }
    public void setMaxHealth(int maxHealth) {
        healthClass.setMaxHealth(maxHealth);
    }
    public int getArmour() {
        return healthClass.getArmour();
    }
    public void setArmour(int armour) {
        healthClass.setArmour(armour);
    }

}