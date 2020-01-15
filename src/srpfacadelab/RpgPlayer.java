package srpfacadelab;

import java.util.List;

public class RpgPlayer {

    public final IGameEngine gameEngine;
    public Facade playerFacade = new Facade();

    // How much the player can carry in pounds

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void useItem(Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = gameEngine.getEnemiesNear(this);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public boolean pickUpItem(Item item) {
        int weight = playerFacade.calculateInventoryWeight();
        if (weight + item.getWeight() > playerFacade.getCarryingCapacity())
            return false;

        if (item.isUnique() && playerFacade.checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        int newHealth = item.healPlayer(playerFacade.getHealth(), playerFacade.getMaxHealth(), gameEngine);
        if (newHealth != playerFacade.getHealth()) {
            playerFacade.setHealth(newHealth);
            return true;
        }

        item.playEffects(gameEngine);

        playerFacade.AddToInventory(item);

        playerFacade.calculateStats(playerFacade.getInventory());

        return true;
    }
}