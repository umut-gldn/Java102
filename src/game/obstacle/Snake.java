package game.obstacle;

public class Snake extends Obstacle {
    public Snake() {
        super(4, "Yılan", (int) (Math.random() * 4) + 3, 12, 0);
    }

    @Override
    public int obstacleNumber() {
        return (int) (Math.random() * 5) + 1;
    }

}
