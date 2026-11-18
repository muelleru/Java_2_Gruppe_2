package uebungen.books;

import java.util.Comparator;

public class Book implements Comparable<Book>{

    private String author;
    private String title;
    private int edition;

    @Override
    public int compareTo(Book o) {
        return this.getAuthor().compareTo(o.getAuthor());
    }

    class Comparer implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }
    public Book(String author, String title, int edition) {
        this.author = author;
        this.title = title;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(author).append(": ");
        sb.append("\"").append(title).append("\"");
        sb.append(" Auflage: ").append(edition).append(" Stück");
        return sb.toString();
    }
}
