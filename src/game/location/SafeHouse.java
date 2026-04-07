package game.location;

import game.model.Player;

public class SafeHouse extends Location {
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("=== GÜVENLİ EV ===");
        player.health = player.maxHealth;
        System.out.println("Canınız tamamen yenilendi!");

        if (player.inventory.hasAllRewards()) {
            System.out.println("Tüm ödülleri topladınız ve güvenli eve döndünüz!");
            System.out.println("OYUNU KAZANDINIZ!");
            return true; 
        }

        System.out.println("Henüz tüm ödülleri toplamadınız.");
        return false;
    }

}
