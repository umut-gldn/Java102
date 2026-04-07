package game.location;

import game.model.*;
import game.manager.InputManager;

public class ToolStore extends Location {

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("=== MAĞAZA === (Para: " + player.money + ")");
        showMenu();
        return false;
    }

    private void showMenu() {
        System.out.println("1 - Silah Al");
        System.out.println("2 - Zırh Al");
        System.out.println("3 - Çık");
        System.out.print("Seçiminiz: ");

        switch (InputManager.getInt()) {
            case 1 -> buyWeapon();
            case 2 -> buyArmor();
            case 3 -> System.out.println("Güle güle!");
            default -> System.out.println("Geçersiz seçim!");
        }
    }

    private void buyWeapon() {
        WeaponType[] weapons = WeaponType.values();
        System.out.println("--- SİLAHLAR ---");
        for (WeaponType w : weapons) {
            if (w == WeaponType.YOK)
                continue;
            System.out.println(w.ordinal() + " - " + w.name + " | Hasar: +" + w.damage + " | Fiyat: " + w.price);
        }

        System.out.print("Seçiminiz: ");
        int secim = InputManager.getInt();

        if (secim < 1 || secim >= weapons.length) {
            System.out.println("Geçersiz seçim!");
            return;
        }
        WeaponType selected = weapons[secim];

        purchase(selected.price, () -> {
            player.inventory.weapon = selected;
            System.out.println(selected.name + " satın alındı!");
        });
    }

    private void buyArmor() {
        System.out.println("--- ZIRHLAR ---");
        ArmorType[] armors = ArmorType.values();

        for (ArmorType a : armors) {
            if (a == ArmorType.YOK)
                continue;
            System.out.println(a.ordinal() + " - " + a.name +
                    " | Savunma: +" + a.defence +
                    " | Fiyat: " + a.price);
        }

        System.out.print("Seçiminiz: ");
        int secim = InputManager.getInt();

        if (secim < 1 || secim >= armors.length) {
            System.out.println("Geçersiz seçim!");
            return;
        }
        ArmorType selected = armors[secim];
        purchase(selected.price, () -> {
            player.inventory.armor = selected;
            System.out.println(selected.name + " satın alındı!");
        });
    }

    private void purchase(int price, Runnable action) {
        if (player.money >= price) {
            player.money -= price;
            action.run();
        } else {
            System.out.println("Yeterli paranız yok! (Gereken: " + price + " | Mevcut: " + player.money + ")");
        }
    }
}
