package patikaStore.model;

public class Notebook extends Product {
    private int ram;
    private int storage;
    private double screenSize;

    public Notebook(int id, String name, double unitPrice, double discountRate, int stock, Brand brand, int ram,
            int storage, double screenSize) {
        super(id, name, unitPrice, discountRate, stock, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public int getRow() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public void printTableHeader() {
        System.out.println("Notebook listesi");
        System.out.println("--------------------------------");
        System.out.format("| %-4s | %-29s | %-9s | %-9s | %-9s | %-9s | %-11s |%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("--------------------------------");
    }

    @Override

    public void printRow() {
        System.out.format("| %-4d | %-29s | %-9s | %-9s | %-9d | %-9.1f | %-11d |%n",
                getId(), getName(), getUnitPrice() + " TL", getBrand().getName(),
                storage, screenSize, ram);
    }
}
