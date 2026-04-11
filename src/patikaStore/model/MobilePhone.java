package patikaStore.model;

public class MobilePhone extends Product {
 private int storage;
    private double screenSize;
    private int battery;
    private int ram;
    private String color;
    private int camera;

    public MobilePhone(int id, String name, double unitPrice, double discountRate, int stock,
                       Brand brand, int storage, double screenSize, int battery, int ram, String color, int camera) {
        super(id, name, unitPrice, discountRate, stock, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
        this.camera = camera;
    }

    public int getStorage() { return storage; }
    public double getScreenSize() { return screenSize; }
    public int getBattery() { return battery; }
    public int getRam() { return ram; }
    public String getColor() { return color; }
    public int getCamera() { return camera; }

    @Override
    public void printTableHeader() {
        System.out.println("Cep Telefonu Listesi\n");
        System.out.println("-".repeat(134));
        System.out.format("| %-4s | %-29s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s |%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println("-".repeat(134));
    }

    @Override
    public void printRow() {
        System.out.format("| %-4d | %-29s | %-9s | %-9s | %-9d | %-9.1f | %-9d | %-9d | %-9d | %-9s |%n",
                getId(), getName(), getUnitPrice() + " TL", getBrand().getName(),
                storage, screenSize, camera, battery, ram, color);
    }
}
