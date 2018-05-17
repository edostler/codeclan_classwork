import db.DBHelper;
import models.Author;
import models.Book;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Author author1 = new Author("Robert Rankin");
        DBHelper.saveOrUpdate(author1);
        Author author2 = new Author("Stephen King");
        DBHelper.saveOrUpdate(author2);
        Book book1 = new Book("The Hollow Chocolate Bunnies of the Apocalypse", 7.99, author1);
        DBHelper.saveOrUpdate(book1);
        Book book2 = new Book("The Stand", 17.99, author2);
        DBHelper.saveOrUpdate(book2);
        List<Book> books = DBHelper.getAll("Book");
        List<Author> authors = DBHelper.getAll("Author");

        Object book1_by_id = DBHelper.getGenericById(book1.getId(), "Book");
        Object book2_by_id = DBHelper.getGenericById(book2.getId(), "Book");
        Object author1_by_id = DBHelper.getGenericById(author1.getId(), "Author");
        Object author2_by_id = DBHelper.getGenericById(author2.getId(), "Author");

        List<Book> author1_books = DBHelper.getBooksByAuthorId(author1.getId());

        DBHelper.deleteAll("Book");
        List<Book> books_deleted = DBHelper.getAll("Book");
        List<Author> authors_not_deleted = DBHelper.getAll("Author");

        author1.setName("Ian Rankin");
        DBHelper.saveOrUpdate(author1);
        List<Author> authors_not_deleted_updated = DBHelper.getAll("Author");

        DBHelper.delete(author1);
        List<Author> authors_not_deleted_updated_one_deleted = DBHelper.getAll("Author");

    }

}
