package Java102.src.generic;

public class Main {
    public static void main(String[] args) {
        // Test 1 — size ve kapasite
        MyList<Integer> liste = new MyList<>();
        System.out.println("Dizideki Eleman Sayısı : " + liste.getSize());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());

        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        System.out.println("Dizideki Eleman Sayısı : " + liste.getSize());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());

        liste.add(50);
        liste.add(60);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Dizideki Eleman Sayısı : " + liste.getSize());
        System.out.println("Dizinin Kapasitesi : " + liste.getCapacity());

        System.out.println("===========================");

        // Test 2 — get, remove, set, toString
        MyList<Integer> liste2 = new MyList<>();
        liste2.add(10);
        liste2.add(20);
        liste2.add(30);
        System.out.println("2. indisteki değer : " + liste2.get(2));
        liste2.remove(2);
        liste2.add(40);
        liste2.set(0, 100);
        System.out.println("2. indisteki değer : " + liste2.get(2));
        System.out.println(liste2.toString());

        System.out.println("===========================");

        // Test 3 — indexOf, lastIndexOf, toArray, subList, contains, clear
        MyList<Integer> liste3 = new MyList<>();
        System.out.println("Liste Durumu : " + (liste3.isEmpty() ? "Boş" : "Dolu"));
        liste3.add(10);
        liste3.add(20);
        liste3.add(30);
        liste3.add(40);
        liste3.add(20);
        liste3.add(50);
        liste3.add(60);
        liste3.add(70);

        System.out.println("Liste Durumu : " + (liste3.isEmpty() ? "Boş" : "Dolu"));
        System.out.println("Indeks : " + liste3.indexOf(20));
        System.out.println("Indeks : " + liste3.indexOf(100));
        System.out.println("Indeks : " + liste3.lastIndexOf(20));

        Object[] dizi = liste3.toArray();
        System.out.println("Object dizisinin ilk elemanı : " + dizi[0]);

        MyList<Integer> altListe = liste3.subList(0, 3);
        System.out.println(altListe.toString());

        System.out.println("Listemde 20 değeri : " + liste3.contains(20));
        System.out.println("Listemde 120 değeri : " + liste3.contains(120));

        liste3.clear();
        System.out.println(liste3.toString());
    }

}
