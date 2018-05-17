package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    private Borrower borrower;

    @Before
    public void before() {
        borrower = new Borrower("Ed");
    }

    @Test
    public void canGetName() {
        assertEquals("Ed", borrower.getName());
    }

}
