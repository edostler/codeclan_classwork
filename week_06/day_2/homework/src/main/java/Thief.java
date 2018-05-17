import java.util.ArrayList;

public class Thief {

    private String name;
    private ArrayList<Book> stash;

    public Thief(String name) {
        this.name = name;
        this.stash = new ArrayList<>();
    }

    public int getStashSize() {
        return this.stash.size();
    }

    public void addBookToStash(Book book) {
        this.stash.add(book);
    }

    public void stealBookFromLibrary(Library library) {
        Book book = library.removeBookFromStock();
        addBookToStash(book);
    }
}
