package is.hi.hbv202g.project;

/**
 * FacultyMember class - represents a faculty member with a name and a department
 */
public class FacultyMember extends User{

    private String department;

    /**
     * Constructor
     * 
     * @param name name of the faculty member
     * @param department department of the faculty member
     */
    public FacultyMember(String name, String department) {
        super(name);
        this.department = department;
    }

    /**
     * Get the department of the faculty member
     * 
     * @return department of the faculty member
     */
    public String getDepartment() {
        return this.department;
    }
    
    /**
     * Set the department of the faculty member
     * 
     * @param department department of the faculty member
     */
    public void setDepartment(String department) {
        this.department = department;
    }
}
