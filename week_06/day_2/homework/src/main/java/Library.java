import java.util.ArrayList;

public class Library {

    //declarations
    private String name;
    private int capacity;
    private ArrayList<Book> stock;

    //constructor
    public Library(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.stock = new ArrayList<>();
    }

    //methods
    public int getStockSize() {
        return this.stock.size();
    }

    public void addBookToLibrary(Book book) {
        if (this.stock.size() < this.capacity) {
            this.stock.add(book);
        }
    }

    public Book removeBookFromStock() {
        if (this.stock.size() > 0) {
            return this.stock.remove(0);
        }
        return null;
    }
}
