package patikaStore.manager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import patikaStore.model.Brand;

public class BrandManager {
    private final List<Brand> brands = new ArrayList<>();
    private int nextId = 1;

    public BrandManager() {
        String[] defaultBrands = { "Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi",
                "Monster" };
        for (String name : defaultBrands) {
            brands.add(new Brand(nextId++, name));
        }
    }

    public List<Brand> getAll() {
        List<Brand> sorted = new ArrayList<>(brands);
        sorted.sort(Comparator.comparing(Brand::getName));
        return sorted;
    }

    public Brand findById(int id) {
        return brands.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Brand findByName(String name) {
        return brands.stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void printBrands() {
        System.out.println("\nMarkalarımız");
        System.out.println("--------------");
        for (Brand b : getAll()) {
            System.out.println("- " + b.getName());
        }
        System.out.println();
    }

    public void printBrandsWithId() {
        System.out.println("\nMarkalar:");
        for (Brand b : getAll()) {
            System.out.printf("  [%d] %s%n", b.getId(), b.getName());
        }
        System.out.println();
    }

}
