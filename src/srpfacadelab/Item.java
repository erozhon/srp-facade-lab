package srpfacadelab;

public class Item implements ItemInterface {

    private int id;

    private String name;

    // How much the item heals by.
    private int heal;

    // How much armour the player gets when it is equipped.
    private int armour;

    // How much this item weighs in pounds.
    private int weight;

    // A unique item can only be picked up once.
    private boolean unique;

    // Rare items are shiny
    private final boolean rare;

    public Item(int id, String name, int heal, int armour, int weight, boolean unique, boolean rare)
    {
        this.rare = rare;
        this.setName(name);
        this.setHeal(heal);
        this.setArmour(armour);
        this.setWeight(weight);
        this.setUnique(unique);
        this.setId(id);
    }

    public void playEffects(IGameEngine gameEngine) {
        if (this.isRare() && this.isUnique()) {
            gameEngine.playSpecialEffect("blue_swirly");
        } else if (this.isRare()) {
            gameEngine.playSpecialEffect("cool_swirly_particles");
        }
    }

    public int healPlayer(int health, int maxHealth, IGameEngine gameEngine) { 
        if (this.getHeal() > 0) {
            health += this.getHeal();

            if (health > maxHealth)
                health = maxHealth;

            if (this.getHeal() > 500) {
                gameEngine.playSpecialEffect("green_swirly");
            }
        }
        return health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public boolean isRare() {
        return rare;
    }
}
