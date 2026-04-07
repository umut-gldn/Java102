package game.manager;

import game.model.Player;
import game.obstacle.Obstacle;

public class CombatManager {

    public static boolean fight(Player player, Obstacle obstacle) {
        System.out.println("\n " + obstacle.name + " ile savaş başlıyor!");
        System.out.println(obstacle.name + " → Can: " + obstacle.health + " | Hasar: " + obstacle.damage);

        boolean playerFirst = Math.random() < 0.5;
        System.out.println(playerFirst ? "İlk hamle sizin!" : "İlk hamle düşmanın!");

        while (!obstacle.isDead() && !player.isDead()) {
            if (playerFirst) {
                playerAttack(player, obstacle);
                if (!obstacle.isDead())
                    enemyAttack(player, obstacle);

            } else {
                enemyAttack(player, obstacle);
                if (!player.isDead())
                    playerAttack(player, obstacle);
            }
        }
        if (player.isDead()) {
            System.out.println("Hayatta kalmayı başaramadınız...");
            return false;
        }

        System.out.println(obstacle.name + " yenildi! +" + obstacle.money + " para");
        player.money += obstacle.money;
        return true;
    }

    private static void playerAttack(Player player, Obstacle obstacle) {
        int dmg = player.getTotalDamage();
        obstacle.health -= dmg;
        System.out.println("Düşmana " + dmg + " hasar | Düşman can: " + Math.max(0, obstacle.health));
    }

    private static void enemyAttack(Player player, Obstacle obstacle) {
        int dmg = Math.max(0, obstacle.damage - player.getTotalDefence());
        player.health -= dmg;
        System.out.println(obstacle.name + " " + dmg + " hasar verdi | Canınız: " + Math.max(0, player.health));
    }

}
