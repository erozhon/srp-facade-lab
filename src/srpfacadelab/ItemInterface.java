package srpfacadelab;

public interface ItemInterface {
    public void playEffects(IGameEngine iGameEngine);
    public int healPlayer(int health, int maxHealth, IGameEngine iGameEngine);
}