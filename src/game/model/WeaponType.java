package game.model;

public enum WeaponType {
    YOK("Yok",0,0),
    TABANCA("Tabanca",5,5),
    KILIC("Kılıç",10,10),
    TUFEK("Tüfek",15,15);


    public final String name;
    public final int damage;
    public final int price;

    WeaponType(String name, int damage, int price) {
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

}
