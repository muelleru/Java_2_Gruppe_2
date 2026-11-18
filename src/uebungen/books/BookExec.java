package uebungen.books;

import java.util.*;

public class BookExec {

    private Book[] books;

    public BookExec() {
        books = new Book[] {
                new Book("Goethe","Faust", 20000),
                new Book("Schiller","Wilhelm Tell", 10000),
                new Book("Fontane","Effi Briest", 10000),
                new Book("Lessing","Nathan der Weise", 11000),
                new Book("Mörike","Maler Nolten", 4000),
                new Book("Hegel","Phänomenologie des Geistes", 8000)
        };
    }

    public void u01() {
        ArrayList<Book> l1 = new ArrayList<>();
        l1.addAll(Arrays.asList(books));

        System.out.println("** Nach Autor");
        l1.sort( (b1,b2) -> b1.getAuthor().compareTo(b2.getAuthor()));
        Collections.sort(l1, (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));
        Collections.sort(l1, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getAuthor().compareTo(b2.getAuthor());
            }
        });

        l1.forEach(System.out::println);
        System.out.println("** Nach Autor DESC");
        l1.sort( (b1,b2) -> b2.getAuthor().compareTo(b1.getAuthor()));
        l1.forEach(System.out::println);

        System.out.println("** Nach Titel");
        l1.sort( (b1,b2) -> b1.getTitle().compareTo(b2.getTitle()));
        l1.forEach(System.out::println);
        System.out.println("** Nach Titel DESC");
        l1.sort( (b1,b2) -> b2.getTitle().compareTo(b1.getTitle()));
        l1.forEach(System.out::println);

        System.out.println("** Nach Auflage");
        l1.sort( (b1,b2) -> b1.getEdition() - b2.getEdition());
        l1.forEach(System.out::println);

        System.out.println("** Nach Auflage DESC");
        l1.sort( (b1,b2) -> b2.getEdition() - b1.getEdition());
        l1.forEach(System.out::println);
    }
    public void u02() {
        LinkedList<Book> ll = new LinkedList<>();
        for(Book b : books) {
            ll.addLast(b);
        }
        System.out.println(ll);
    }
    public void u03() {
        Map<String,Book> map = new HashMap<>();
        for(Book b : books) {
            map.put(b.getAuthor()+"_" + b.getTitle().replace(" ","_"), b);
        }
        System.out.println(map);
    }
    static void main() {
        BookExec be = new BookExec();
        be.u01();
        be.u02();
        be.u03();
    }


}
