package game.model;

public class Player {
    public String name;
    public int health;
    public int maxHealth;
    public int damage;
    public int money;
    public Inventory inventory;

    public Player() {
        this.inventory = new Inventory();
        this.money = 20;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public int getTotalDamage() {
        return damage + inventory.weapon.damage;
    }

    public int getTotalDefence() {
        return inventory.armor.defence;
    }

    public void printStatus() {
        System.out.println("[" + name + "] Can: " + health + " | Para: " + money);

    }

}
