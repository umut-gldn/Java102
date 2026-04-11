package patikaStore.model;

public abstract class Product {
    private final int id;
    private String name;
    private double unitPrice;
    private double discountRate;
    private int stock;
    private Brand brand;

    public Product(int id, String name, double unitPrice, double discountRate, int stock, Brand brand) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stock = stock;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public abstract void printTableHeader();
    public abstract void printRow();
}
