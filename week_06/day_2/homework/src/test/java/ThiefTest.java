import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThiefTest {

    private Thief thief;
    private Book book;
    private Library library;

    @Before
    public void before() {
        thief = new Thief("Ed");
        book = new Book("The Hollow Chocolate Bunnies of the Apocalypse", "Robert Rankin", 352, 2002, GenreType.COMEDY);
        library = new Library("Ostler Library", 5);
    }

    @Test
    public void canGetStashSize() {
        assertEquals(0, thief.getStashSize());
    }

    @Test
    public void canAddBookToStash() {
        thief.addBookToStash(book);
        assertEquals(1, thief.getStashSize());
    }


    @Test
    public void canStealBookFromLibrary(){
        library.addBookToLibrary(book);
        thief.stealBookFromLibrary(library);
        assertEquals(1, thief.getStashSize());
    }

}
