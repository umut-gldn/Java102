package generic;

public class MyList<T> {
    private Object[] dizi;
    private int size;
    private int capacity;
    private static final int VARSAYILAN_KAPASITE = 10;

    public MyList() {
        this.capacity = VARSAYILAN_KAPASITE;
        this.dizi = new Object[capacity];
        this.size = 0;
    }

    public MyList(int capacity) {
        if (capacity <= 0) {
            this.capacity = VARSAYILAN_KAPASITE;
        } else {
            this.capacity = capacity;
        }
        this.dizi = new Object[this.capacity];
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T data) {
        if (size == capacity) {
            capacity = capacity * 2;
            Object[] yeniDizi = new Object[capacity];
            for (int i = 0; i < size; i++) {
                yeniDizi[i] = dizi[i];
            }
            dizi = yeniDizi;
        }
        dizi[size] = data;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        return (T) dizi[index];
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size)
            return null;

        T silinen = (T) dizi[index];
        for (int i = index; i < size - 1; i++) {
            dizi[i] = dizi[i + 1];
        }
        dizi[size - 1] = null;
        size--;
        return silinen;
    }

    @SuppressWarnings("unchecked")
    public T set(int index, T data) {
        if (index < 0 || index >= size)
            return null;
        T eski = (T) dizi[index];
        dizi[index] = data;
        return eski;
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (dizi[i] == null && data == null) {
                return i;
            }
            if (dizi[i] != null && dizi[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (dizi[i] == null && data == null) {
                return i;
            }
            if (dizi[i] != null && dizi[i].equals(data))
                return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        Object[] sonuc = new Object[size];
        for (int i = 0; i < size; i++) {
            sonuc[i] = dizi[i];
        }
        return sonuc;
    }

    public void clear() {
        dizi = new Object[VARSAYILAN_KAPASITE];
        capacity = VARSAYILAN_KAPASITE;
        size = 0;
    }

    public MyList<T> subList(int start, int finish) {
        if (start < 0 || finish > size || start > finish)
            return null;
        MyList<T> altListe = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            altListe.add(get(i));
        }
        return altListe;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    public String toString() {
        if (isEmpty())
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(dizi[i]);
            if (i < size - 1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
