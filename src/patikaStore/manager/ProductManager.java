package patikaStore.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import patikaStore.model.MobilePhone;
import patikaStore.model.Notebook;
import patikaStore.model.Product;

public class ProductManager<T extends Product> {
    private final List<T> products = new ArrayList<>();
    private int nextId = 1;

    public int generateId() {
        return nextId++;
    }

    public void add(T product) {
        products.add(product);
    }

    public boolean deleteById(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    public List<T> getAll() {
        return new ArrayList<>(products);
    }

    public T findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<T> filterById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .collect(Collectors.toList());
    }

    public List<T> filterByBrandName(String brandName) {
        return products.stream()
                .filter(p -> p.getBrand().getName().equalsIgnoreCase(brandName))
                .collect(Collectors.toList());
    }

    public void printAll() {
        if (products.isEmpty()) {
            System.out.println("Listelenecek ürün bulunamadı.\n");
            return;
        }
        products.get(0).printTableHeader();
        for (T p : products) {
            p.printRow();
        }
        System.out.println("-".repeat(getLineLength(products.get(0))));
        System.out.println();
    }

    public void printList(List<T> list) {
        if (list.isEmpty()) {
            System.out.println("Eşleşen ürün bulunamadı.\n");
            return;
        }
        list.get(0).printTableHeader();
        for (T p : list) {
            p.printRow();
        }
        System.out.println("-".repeat(getLineLength(list.get(0))));
        System.out.println();
    }

    private int getLineLength(Product p) {
        if (p instanceof Notebook)
            return 100;
        if (p instanceof MobilePhone)
            return 134;
        return 100;
    }

}
