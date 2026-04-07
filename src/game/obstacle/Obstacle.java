package game.obstacle;

public abstract class Obstacle {

    public int id;
    public String name;
    public int damage;
    public int health;
    public int money;

    public Obstacle(int id, String name, int damage, int health, int money) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int obstacleNumber() {
        return (int) (Math.random() * 3) + 1;
    }

    public boolean isDead() {
        return health <= 0;
    }

}
