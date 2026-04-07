package game.manager;

import game.model.Player;

public class CharacterManager {
    public static void selectCharacter(Player player) {
        System.out.println("======= KARAKTER SEÇİMİ =======");
        System.out.println("1 - Savaşçı  (Can: 100 | Hasar: 15)");
        System.out.println("2 - Hızlı    (Can:  80 | Hasar: 10)");
        System.out.println("3 - Büyücü   (Can:  60 | Hasar: 20)");
        System.out.print("Seçiminiz: ");
        int secim = InputManager.getInt();

        System.out.print("Karakterinizin adı: ");
        player.name = InputManager.getString();

        switch (secim) {
            case 1 -> {
                player.health = 100;
                player.maxHealth = 100;
                player.damage = 15;
            }
            case 2 -> {
                player.health = 80;
                player.maxHealth = 80;
                player.damage = 10;
            }
            case 3 -> {
                player.health = 60;
                player.maxHealth = 60;
                player.damage = 20;
            }
            default -> {
                System.out.println("Geçersiz seçim — Savaşçı seçildi.");
                player.health = 100;
                player.maxHealth = 100;
                player.damage = 15;
            }
        }

        System.out.println(player.name + " hazır!");
    }
}
