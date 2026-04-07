package game.location;

import game.model.Player;
import game.obstacle.*;

public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player, "Mağara");
    }

    @Override
    protected Obstacle createObstacle() {
        return new Zombie();
    }

    @Override
    protected void giveReward(int count) {
        player.inventory.food = true;
        System.out.println(" Mağara temizlendi! Yemek kazandınız.");
    }

    @Override
    public boolean onLocation() {
        System.out.println("=== MAĞARA ===");
        combat();
        return false;
    }
}
