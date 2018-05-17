import java.util.ArrayList;

public class Book {

    private String title;
    private String author;
    private int pages;
    private int year;
    private GenreType genre;

    public Book(String title, String author, int pages, int year, GenreType genre) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
        this.genre = genre;
    }

    public GenreType getGenre() {
        return this.genre;
    }

    public String getDescriptionFromEnum() {
        return this.genre.getDescription();
    }
}
