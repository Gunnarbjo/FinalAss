package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class LendingTest {
    private Lending lending;
    private Book book;
    private User user;

    /*
     * Set up a lending, a book and a user before each test
     */
    @Before
    public void setUp() {
        book = new Book("The Hobbit", "J.R.R. Tolkien");
        user = new FacultyMember("Jón Jónsson", "Tölvunarfræði");
        lending = new Lending(book, user);
    }
    /*
     * Test if a lending can be created
     */
    @Test
    public void testCreateLending() {
        lending = new Lending(book, user);
    }

    /*
     * Test if the due date is returned correctly
     */
    @Test
    public void testGetDueDate() {
        lending = new Lending(book, user);
        assert(lending.getDueDate().equals(LocalDate.now().plusDays(30)));
    }
    /*
     * Test if the due date is set correctly
     */
    @Test
    public void testSetDueDate() {
        lending.setDueDate(LocalDate.now().plusDays(10));
        assert(lending.getDueDate().equals(LocalDate.now().plusDays(10)));
    }
    /*
     * Test if the book is returned correctly
     */
    @Test
    public void testGetBook() {
        assert(lending.getBook().equals(book));
    }
    /*
     * Test if the book is set correctly
     */
    @Test
    public void testSetBook() {
        Book newBook = new Book("The Lord of the Rings", "J.R.R. Tolkien");
        lending.setBook(newBook);
        assert(lending.getBook().equals(newBook));
    }
    /*
     * Test if the user is returned correctly
     */
    @Test
    public void testGetUser() {
        assert(lending.getUser().equals(user));
    }
    /*
     * Test if the user is set correctly
     */
    @Test
    public void testSetUser() {
        User newUser = new FacultyMember("Jón Jónssonsson", "Tölvunarfræði");
        lending.setUser(newUser);
        assert(lending.getUser().equals(newUser));
    }
    /*
     * Test if the lending is overdue
     */
    @Test
    public void testIsOverdue() {
        lending.setDueDate(LocalDate.now().minusDays(1));
        assert(lending.isOverdue());
    }
    /*
     * Test if the lending is not overdue
     */
    @Test
    public void testIsNotOverdue() {
        lending.setDueDate(LocalDate.now().plusDays(1));
        assert(!lending.isOverdue());
    }
    /*
     * Test if the lending is not overdue when the due date is today
     */
    @Test
    public void testIsNotOverdueToday() {
        lending.setDueDate(LocalDate.now());
        assert(!lending.isOverdue());
    }
}
