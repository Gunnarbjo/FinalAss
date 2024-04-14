package is.hi.hbv202g.assignment8;

import java.util.List;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class BookTest {

    private Book book;
    private List<Author> authors;

    /*
     * Set up a book and a list of authors before each test
     */
    @Before
    public void setUp() throws EmptyAuthorListException{
        authors = new ArrayList<Author>();
        authors.add(new Author("J.R.R. Tolkien"));
        authors.add(new Author("Jón Jónsson"));
        book = new Book("The Hobbit", authors);
    }
    /*
     * Test if the title is returned correctly
     */
    @Test
    public void testGetTitle() {
        assert(book.getTitle().equals("The Hobbit"));
    }
    /*
     * Test if the title is set correctly
     */
    @Test
    public void testSetTitle() {
        book.setTitle("The Lord of the Rings");
        assert(book.getTitle().equals("The Lord of the Rings"));
    }
    /*
     * Test if the authors are returned correctly
     */
    @Test
    public void testGetAuthors() {
    List<Author> testAuthors = book.getAuthors();
    assert testAuthors.size() == authors.size() && 
           testAuthors.containsAll(authors) && 
           authors.containsAll(testAuthors);
}
    /*
     * Test if the authors are set correctly
     */
    @Test
    public void testSetAuthors() throws EmptyAuthorListException{
        book.setAuthors(authors);
        assert(book.getAuthors().equals(authors));
    }
    /**
     *  Test if author is added to the list of authors
     */
    @Test
    public void testAddAuthor() {
        Author newAuthor = new Author("Jón Jónsson");
        book.addAuthor(newAuthor);
        assert(book.getAuthors().contains(newAuthor));
    }

    /*
     * Test if an exception is thrown when trying to set an empty list of authors
     */
    @Test(expected = EmptyAuthorListException.class)
    public void testSetAuthorsEmpty() throws EmptyAuthorListException{
        List<Author> emptyAuthors = new ArrayList<Author>();
        book.setAuthors(emptyAuthors);
    }
    
    /*
     * Tests the Book constructor with two authors
     */
    @Test
    public void testBookConstructorWithTwoAuthors() throws EmptyAuthorListException {
        
        Book book = new Book("The Hobbit", authors);
        List<Author> testAuthors = book.getAuthors();
        assert testAuthors.size() == authors.size() && 
               testAuthors.containsAll(authors) && 
               authors.containsAll(testAuthors);
    }
    
}
