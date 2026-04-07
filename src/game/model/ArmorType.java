package game.model;

public enum ArmorType {
    YOK("Yok",0,0),
    HAFIF("Hafif Zırh",3,5),
    ORTA("Orta Zırh",6,10),
    AGIR("Ağır Zırh",10,15);



    public final String name;
    public final int defence;
    public final int price;

    ArmorType(String name, int defence, int price) {
        this.name = name;
        this.defence = defence;
        this.price = price;
    }


}
