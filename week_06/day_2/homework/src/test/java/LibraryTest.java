import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book;

    @Before
    public void before() {
        library = new Library("Ostler Library", 5);
        book = new Book("The Hollow Chocolate Bunnies of the Apocalypse", "Robert Rankin", 352, 2002, GenreType.COMEDY);
    }

    @Test
    public void canGetStockSize() {
        assertEquals(0, library.getStockSize());
    }

    @Test
    public void canAddBookToLibrary__library_has_space() {
        library.addBookToLibrary(book);
        library.addBookToLibrary(book);
        library.addBookToLibrary(book);
        library.addBookToLibrary(book);
        library.addBookToLibrary(book);
        assertEquals(5, library.getStockSize());
    }

    @Test
    public void canAddBookToLibrary__library_has_no_space() {
        library.addBookToLibrary(book);
        library.addBookToLibrary(book);
        library.addBookToLibrary(book);
        library.addBookToLibrary(book);
        library.addBookToLibrary(book);
        library.addBookToLibrary(book);
        assertEquals(5, library.getStockSize());
    }

    @Test
    public void canRemoveBookFromStock__stock_has_book() {
        library.addBookToLibrary(book);
        assertEquals(1, library.getStockSize());
        library.removeBookFromStock();
        assertEquals(0, library.getStockSize());
    }

    @Test
    public void canRemoveBookFromStock__stock_has_no_book() {
        assertEquals(0, library.getStockSize());
        library.removeBookFromStock();
        assertEquals(0, library.getStockSize());
    }

}
