package game.location;

import game.manager.LootManager;
import game.model.Player;
import game.obstacle.*;

public class Mine extends BattleLoc {
    public Mine(Player player) {
        super(player, "Maden");
    }

    @Override
    protected Obstacle createObstacle() {
        return new Snake();
    }

    @Override
    protected void giveReward(int count) {
        System.out.println(" Maden temizlendi! Ganimet zamanı...");

        LootManager.dropLoot(player);

    }

    @Override
    public boolean onLocation() {
        System.out.println("=== MADEN ===");
        combat();
        return false;
    }
}
