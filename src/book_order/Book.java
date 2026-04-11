package book_order;

public class Book implements Comparable<Book> {

    private String name;
    private int pageCount;
    private String author;
    private int publishYear;

    public Book(String name, int pageCount, String author, int publishYear) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    @Override
    public int compareTo(Book other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " | " + pageCount + " sayfa | " + author + " | " + publishYear;
    }

}
