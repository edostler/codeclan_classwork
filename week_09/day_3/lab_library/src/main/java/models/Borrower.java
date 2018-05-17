package models;

import java.util.ArrayList;
import java.util.List;

public class Borrower {

    private int id;
    private String name;
    private List<Book> borrowedBooks;

    public Borrower(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

}
