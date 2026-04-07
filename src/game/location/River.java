package game.location;

import game.model.Player;
import game.obstacle.*;

public class River extends BattleLoc {

    public River(Player player) {
        super(player, "Nehir");
    }

    @Override
    protected Obstacle createObstacle() {
        return new Bear();
    }

    @Override
    protected void giveReward(int count) {
        player.inventory.water = true;
        System.out.println(" Nehir temizlendi! Su kazandınız.");
    }

    @Override
    public boolean onLocation() {
        System.out.println("=== NEHİR ===");
        combat();
        return false;
    }
}
