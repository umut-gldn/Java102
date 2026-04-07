package game;

import game.location.*;
import game.manager.*;
import game.model.*;



public class Game {
    private final Player player;

    // bölgeler
    private final SafeHouse safeHouse;
    private final ToolStore toolstore;
    private final Forest forest;
    private final Cave cave;
    private final River river;
    private final Mine mine;

    public Game() {
        this.player = new Player();

       
        this.safeHouse = new SafeHouse(player);
        this.toolstore = new ToolStore(player);
        this.forest = new Forest(player);
        this.cave = new Cave(player);
        this.river = new River(player);
        this.mine = new Mine(player);
    }

    public void start() {
        System.out.println("=================================");
        System.out.println("   MACERA OYUNUNA HOŞGELDİNİZ   ");
        System.out.println("=================================");

      
        CharacterManager.selectCharacter(player);

        boolean gameOver = false;

        while (!gameOver) {
            if (player.isDead()) {
                System.out.println("☠ Canınız bitti. Oyunu kaybettiniz!");
                break;
            }

            showMenu();
            int secim = InputManager.getInt();
            System.out.println();

            gameOver = switch (secim) {
                case 1 -> safeHouse.onLocation();
                case 2 -> {
                    toolstore.onLocation();
                    yield false;
                }
                case 3 -> {
                    forest.onLocation();
                    yield false;
                }
                case 4 -> {
                    cave.onLocation();
                    yield false;
                }
                case 5 -> {
                    river.onLocation();
                    yield false;
                }
                case 6 -> {
                    mine.onLocation();
                    yield false;
                }
                case 7 -> {
                    player.inventory.print(player.money);
                    yield false;
                }
                default -> {
                    System.out.println("Geçersiz seçim!");
                    yield false;
                }
            };

            System.out.println();
        }
    }

    private void showMenu() {
        System.out.println("--------- BÖLGE SEÇİMİ ---------");
        player.printStatus();
        System.out.println("1 - Güvenli Ev  (Can yenile / Kazan)");
        System.out.println("2 - Mağaza      (Silah & Zırh al)");
        System.out.println("3 - Orman       (Vampir)");
        System.out.println("4 - Mağara      (Zombi)");
        System.out.println("5 - Nehir       (Ayı)");
        System.out.println("6 - Maden       (Yılan)");
        System.out.println("7 - Envanter");
        System.out.print("Seçiminiz: ");
    }
}
