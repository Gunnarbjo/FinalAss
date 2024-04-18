package is.hi.hbv202g.project;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
    private Student student;

    /*
     * Set up a student before each test
     */
    @Before
    public void setUp() {
        student = new Student("Jón Jónsson", true);
    }
    /*
     * Test if the name is returned correctly
     */
    @Test
    public void testGetName() {
        assert(student.getName().equals("Jón Jónsson"));
    }
    /*
     * Test if the name is set correctly
     */
    @Test
    public void testSetName() {
        student.setName("Jón Jónssonsson");
        assert(student.getName().equals("Jón Jónssonsson"));
    }
    /*
     * Test if the fee is returned correctly
     */
    @Test
    public void testGetFee() {
        assertTrue(student.isFeePaid());
    }
    /*
     * Test if the fee is set correctly
     */
    @Test
    public void testSetFee() {
        student.setFeePaid(false);
        assertTrue(!student.isFeePaid());
    }
}
