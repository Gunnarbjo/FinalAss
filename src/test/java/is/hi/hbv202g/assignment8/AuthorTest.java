package is.hi.hbv202g.assignment8;

import org.junit.Test;
import org.junit.Before;

public class AuthorTest {
    private Author author;

    /*
     * Set up an author before each test
     */
    @Before
    public void setUp() {
        author = new Author("Jón Jónsson");
    }

    /*
     * Test if the name is returned correctly
     */
    @Test
    public void testGetName() {
        assert(author.getName().equals("Jón Jónsson"));
    }

    /*
     * Test if the name is set correctly
     */
    @Test
    public void testSetName() {
        author.setName("Jón Jónssonsson");
        assert(author.getName().equals("Jón Jónssonsson"));
    }

    
}
