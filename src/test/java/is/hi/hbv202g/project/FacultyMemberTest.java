package is.hi.hbv202g.project;

import org.junit.Before;
import org.junit.Test;

public class FacultyMemberTest {
    private FacultyMember facultyMember;
    
    /*
     * Set up a faculty member before each test
     */
    @Before
    public void setUp() {
        facultyMember = new FacultyMember("Jón Jónsson", "Tölvunarfræði");
    }
    /*
     * Test if the name is returned correctly
     */
    @Test
    public void testGetName() {
        assert(facultyMember.getName().equals("Jón Jónsson"));
    }
    /*
     * Test if the name is set correctly
     */
    @Test
    public void testSetName() {
        facultyMember.setName("Jón Jónssonsson");
        assert(facultyMember.getName().equals("Jón Jónssonsson"));
    }
    /*
     * Test if the department is returned correctly
     */
    @Test
    public void testGetDepartment() {
        assert(facultyMember.getDepartment().equals("Tölvunarfræði"));
    }
    /*
     * Test if the department is set correctly
     */
    @Test
    public void testSetDepartment() {
        facultyMember.setDepartment("Líffræði");
        assert(facultyMember.getDepartment().equals("Líffræði"));
    }
} 
