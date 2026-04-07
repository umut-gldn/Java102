package game.manager;

import game.model.ArmorType;
import game.model.Player;
import game.model.WeaponType;

public class LootManager {

    public static void dropLoot(Player player) {
        double roll = Math.random() * 100;
        if (roll < 15) {
            dropWeapon(player);
        } 
        else if (roll < 30) {
            dropArmor(player);
        } 
        else if (roll < 55) {
            dropMoney(player);
        } 
        else {
            System.out.println("Bu seferlik şans yok...");
        }
    }

    private static void dropWeapon(Player player) {
        double roll = Math.random() * 100;
        WeaponType weapon;

        if (roll < 50)
            weapon = WeaponType.TABANCA;
        else if (roll < 80)
            weapon = WeaponType.KILIC;
        else
            weapon = WeaponType.TUFEK;

        player.inventory.weapon = weapon;
        System.out.println(weapon.name + " kazandınız! (+" + weapon.damage + " hasar)");
    }

    private static void dropArmor(Player player) {
        double roll = Math.random() * 100;
        ArmorType armor;

        if (roll < 50)
            armor = ArmorType.HAFIF; // %50
        else if (roll < 80)
            armor = ArmorType.ORTA; // %30
        else
            armor = ArmorType.AGIR; // %20

        player.inventory.armor = armor;
        System.out.println(armor.name + " kazandınız! (+" + armor.defence + " savunma)");
    }

    private static void dropMoney(Player player) {
        double roll = Math.random() * 100;
        int amount;

        if (roll < 50)
            amount = 1;
        else if (roll < 80)
            amount = 5;
        else
            amount = 10;

        player.money += amount;
        System.out.println(amount + " para kazandınız!");
    }
}
