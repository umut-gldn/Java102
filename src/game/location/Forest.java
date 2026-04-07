package game.location;

import game.model.Player;
import game.obstacle.*;

public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player, "Orman");
    }

    @Override
    protected Obstacle createObstacle() {
        return new Vampire();
    }

    @Override
    protected void giveReward(int count) {
        player.inventory.firewood = true;
        System.out.println(" Orman temizlendi! Odun kazandınız.");
    }

    @Override
    public boolean onLocation() {
        System.out.println("=== ORMAN ===");
        combat();
        return false;
    }
}
