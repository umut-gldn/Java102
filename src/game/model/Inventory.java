package game.model;

public class Inventory {

    public boolean water;
    public boolean food;
    public boolean firewood;

    public WeaponType weapon;
    public ArmorType armor;
   

    public Inventory() {
        this.water = false;
        this.food = false;
        this.firewood = false;
        this.weapon = WeaponType.YOK;
        this.armor = ArmorType.YOK;
    }

    public boolean hasAllRewards() {
        return water && food && firewood;
    }

    public void print(int money) {
        System.out.println("======= ENVANTER =======");
        System.out.println("Su       : " + (water ? "Var" : "Yok"));
        System.out.println("Yemek    : " + (food ? "Var" : "Yok"));
        System.out.println("Odun     : " + (firewood ? "Var" : "Yok"));
        System.out.println("Silah    : " + weapon.name + " (+" + weapon.damage + " hasar)");
        System.out.println("Zırh     : " + armor.name + " (+" + armor.defence + " savunma)");
        System.out.println("Para     : " + money);
        System.out.println("========================");
    }

}
