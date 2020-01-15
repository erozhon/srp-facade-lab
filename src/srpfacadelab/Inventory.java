package srpfacadelab;

import java.util.ArrayList;

public class Inventory {
    public static final int MAX_CARRYING_CAPACITY = 1000;

    private int carryingCapacity;
    private ArrayList<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<Item>();
        carryingCapacity = MAX_CARRYING_CAPACITY;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
    
    public void AddToInventory(Item item) {
        inventory.add(item);
    }

    public boolean checkIfItemExistsInInventory(Item item) {
        for (Item i: inventory) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    public int calculateInventoryWeight() {
        int sum=0;
        for (Item i: inventory) {
            sum += i.getWeight();
        }
        return sum;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

}