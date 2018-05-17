import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void before() {
        book = new Book("The Hollow Chocolate Bunnies of the Apocalypse", "Robert Rankin", 352, 2002, GenreType.COMEDY);
    }

    @Test
    public void canGetGenre() {
        assertEquals(GenreType.COMEDY, book.getGenre());
    }

    @Test
    public void canGetComedyHasDescription() {
        assertEquals("In a modern sense, comedy refers to any discourse or work generally intended to be humorous or amusing by inducing laughter.", book.getDescriptionFromEnum());
    }

    @Test
    public void canGetAllGenres() {
        GenreType[] expected = {GenreType.COMEDY, GenreType.DRAMA, GenreType.FANTASY, GenreType.HORROR, GenreType.ROMANCE};
        GenreType[] genres = GenreType.values();
        assertEquals(5, genres.length);
        assertArrayEquals(expected, genres);
    }

}
