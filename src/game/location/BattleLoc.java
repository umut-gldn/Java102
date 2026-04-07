package game.location;

import game.manager.CombatManager;
import game.model.Player;
import game.obstacle.Obstacle;

public abstract class BattleLoc extends Location {
    protected boolean cleared = false;

    public BattleLoc(Player player, String name) {
        super(player, name);
    }

    protected abstract Obstacle createObstacle();

    protected abstract void giveReward(int count);

    protected void combat() {
        if (cleared) {
            System.out.println("Bu bölge zaten temizlendi, tekrar giremezsiniz!");
            return;
        }

        Obstacle sample = createObstacle();
        int count = sample.obstacleNumber();
        System.out.println(count + " adet " + sample.name + " ile karşılaştınız!");

        int defeated=0;
        for (int i = 0; i < count; i++) {
            Obstacle enemy = createObstacle(); 
            boolean survived = CombatManager.fight(player, enemy);

            if (!survived)
                return; 
        }

        giveReward(defeated);
        cleared = true;
    }

}
