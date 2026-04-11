package patikaStore;

import java.util.Scanner;

import patikaStore.manager.BrandManager;
import patikaStore.manager.ProductManager;
import patikaStore.model.Brand;
import patikaStore.model.MobilePhone;
import patikaStore.model.Notebook;
import patikaStore.model.Product;

public class PatikaStore {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BrandManager brandManager = new BrandManager();
    private static final ProductManager<Notebook> notebookManager = new ProductManager<>();
    private static final ProductManager<MobilePhone> mobileManager = new ProductManager<>();

    public static void main(String[] args) {
        loadSampleData();
        mainMenu();
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz : ");

            switch (readInt()) {
                case 1 -> notebookMenu();
                case 2 -> mobileMenu();
                case 3 -> brandManager.printBrands();
                case 0 -> {
                    System.out.println("Çıkış yapılıyor...");
                    return;
                }
                default -> System.out.println("Geçersiz seçim.\n");
            }
        }
    }

    private static void notebookMenu() {
        while (true) {
            System.out.println("\n--- Notebook İşlemleri ---");
            System.out.println("1 - Notebook Listele");
            System.out.println("2 - Notebook Ekle");
            System.out.println("3 - Notebook Sil");
            System.out.println("4 - ID ile Filtrele");
            System.out.println("5 - Marka ile Filtrele");
            System.out.println("0 - Ana Menü");
            System.out.print("Tercihiniz : ");

            switch (readInt()) {
                case 1 -> notebookManager.printAll();
                case 2 -> addNotebook();
                case 3 -> deleteProduct(notebookManager, "Notebook");
                case 4 -> filterByIdMenu(notebookManager);
                case 5 -> filterByBrandMenu(notebookManager);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Geçersiz seçim.");
            }
        }
    }

    private static void mobileMenu() {
        while (true) {
            System.out.println("\n--- Cep Telefonu İşlemleri ---");
            System.out.println("1 - Cep Telefonu Listele");
            System.out.println("2 - Cep Telefonu Ekle");
            System.out.println("3 - Cep Telefonu Sil");
            System.out.println("4 - ID ile Filtrele");
            System.out.println("5 - Marka ile Filtrele");
            System.out.println("0 - Ana Menü");
            System.out.print("Tercihiniz : ");

            switch (readInt()) {
                case 1 -> mobileManager.printAll();
                case 2 -> addMobilePhone();
                case 3 -> deleteProduct(mobileManager, "Cep Telefonu");
                case 4 -> filterByIdMenu(mobileManager);
                case 5 -> filterByBrandMenu(mobileManager);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Geçersiz seçim.");
            }
        }
    }

    private static void addNotebook() {
        System.out.println("\n-- Notebook Ekle --");
        System.out.print("Ürün Adı : ");
        String name = scanner.nextLine().trim();
        System.out.print("Birim Fiyatı : ");
        double price = readDouble();
        System.out.print("İndirim Oranı (%) : ");
        double discount = readDouble();
        System.out.print("Stok Miktarı : ");
        int stock = readInt();

        Brand brand = selectBrand();
        if (brand == null)
            return;

        System.out.print("RAM (GB) : ");
        int ram = readInt();
        System.out.print("Depolama (GB) : ");
        int storage = readInt();
        System.out.print("Ekran Boyutu (inç) : ");
        double screen = readDouble();

        Notebook nb = new Notebook(notebookManager.generateId(), name, price, discount, stock, brand, ram, storage,
                screen);
        notebookManager.add(nb);
        System.out.println("Notebook başarıyla eklendi.\n");
    }

    private static void addMobilePhone() {
        System.out.println("\n-- Cep Telefonu Ekle --");
        System.out.print("Ürün Adı : ");
        String name = scanner.nextLine().trim();
        System.out.print("Birim Fiyatı : ");
        double price = readDouble();
        System.out.print("İndirim Oranı (%) : ");
        double discount = readDouble();
        System.out.print("Stok Miktarı : ");
        int stock = readInt();

        Brand brand = selectBrand();
        if (brand == null)
            return;

        System.out.print("Depolama (GB) : ");
        int storage = readInt();
        System.out.print("Ekran Boyutu (inç) : ");
        double screen = readDouble();
        System.out.print("Pil Gücü (mAh) : ");
        int battery = readInt();
        System.out.print("RAM (GB) : ");
        int ram = readInt();
        System.out.print("Renk : ");
        String color = scanner.nextLine().trim();
        System.out.print("Kamera (MP) : ");
        int camera = readInt();

        MobilePhone mp = new MobilePhone(mobileManager.generateId(), name, price, discount, stock,
                brand, storage, screen, battery, ram, color, camera);
        mobileManager.add(mp);
        System.out.println("Cep Telefonu başarıyla eklendi.\n");
    }

    private static <T extends Product> void deleteProduct(ProductManager<T> manager, String label) {
        System.out.print(label + " ID girin: ");
        int id = readInt();
        if (manager.deleteById(id)) {
            System.out.println("Ürün silindi.\n");
        } else {
            System.out.println("Bu ID'ye sahip ürün bulunamadı.\n");
        }
    }

    private static <T extends Product> void filterByIdMenu(ProductManager<T> manager) {
        System.out.print("Filtrelemek istediğiniz ID: ");
        int id = readInt();
        manager.printList(manager.filterById(id));
    }

    private static <T extends Product> void filterByBrandMenu(ProductManager<T> manager) {
        brandManager.printBrandsWithId();
        System.out.print("Marka adı girin: ");
        String brandName = scanner.nextLine().trim();
        manager.printList(manager.filterByBrandName(brandName));
    }

    private static Brand selectBrand() {
        brandManager.printBrandsWithId();
        System.out.print("Marka ID seçin: ");
        int brandId = readInt();
        Brand brand = brandManager.findById(brandId);
        if (brand == null)
            System.out.println("Geçersiz marka ID.\n");
        return brand;
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Lütfen geçerli bir sayı girin: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Lütfen geçerli bir sayı girin: ");
            }
        }
    }

    private static void loadSampleData() {
        Brand huawei = brandManager.findByName("Huawei");
        Brand lenovo = brandManager.findByName("Lenovo");
        Brand asus = brandManager.findByName("Asus");
        Brand samsung = brandManager.findByName("Samsung");
        Brand apple = brandManager.findByName("Apple");
        Brand xiaomi = brandManager.findByName("Xiaomi");

        notebookManager.add(
                new Notebook(notebookManager.generateId(), "HUAWEI Matebook 14", 7000, 0, 15, huawei, 16, 512, 14.0));
        notebookManager
                .add(new Notebook(notebookManager.generateId(), "LENOVO V14 IGL", 3699, 0, 20, lenovo, 8, 1024, 14.0));
        notebookManager
                .add(new Notebook(notebookManager.generateId(), "ASUS Tuf Gaming", 8199, 0, 10, asus, 32, 2048, 15.6));

        mobileManager.add(new MobilePhone(mobileManager.generateId(), "SAMSUNG GALAXY A51", 3199, 0, 50, samsung, 128,
                6.5, 4000, 6, "Siyah", 32));
        mobileManager.add(new MobilePhone(mobileManager.generateId(), "iPhone 11 64 GB", 7379, 0, 30, apple, 64, 6.1,
                3046, 6, "Mavi", 5));
        mobileManager.add(new MobilePhone(mobileManager.generateId(), "Redmi Note 10 Pro", 4012, 0, 40, xiaomi, 128,
                6.5, 4000, 12, "Beyaz", 35));
    }
}
