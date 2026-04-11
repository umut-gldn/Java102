package book_order;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> byName = new TreeSet<>();
        byName.add(new Book("Sefiller", 1232, "Victor Hugo", 1862));
        byName.add(new Book("Atomların Barışı", 320, "Refik Durbaş", 2001));
        byName.add(new Book("Dönüşüm", 96, "Franz Kafka", 1915));
        byName.add(new Book("Beyaz Diş", 328, "Jack London", 1906));
        byName.add(new Book("Zindan", 280, "Kemal Tahir", 1954));

        System.out.println("-- İsme Göre (A-Z) --");
        for (Book b : byName) {
            System.out.println(b);
        }

        TreeSet<Book> byPageCount = new TreeSet<>(Comparator.comparingInt(Book::getPageCount));
        byPageCount.addAll(byName);

        System.out.println("\n-- Sayfa Sayısına Göre --");
        for (Book b : byPageCount) {
            System.out.println(b);
        }
    }
}
