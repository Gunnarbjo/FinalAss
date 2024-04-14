package is.hi.hbv202g.assignment8;

/**
 * Student class - represents a student user
 */
public class Student extends User{

    private boolean feePaid;

    /**
     * Constructor
     * 
     * @param name name of the student
     * @param feePaid true if the fee is paid, false otherwise
     */
    public Student(String name, boolean feePaid) {
        super(name);
        this.feePaid = feePaid;

    }

    /**
     * Returns true if the fee is paid, false otherwise
     * 
     * @return true if the fee is paid, false otherwise
     */
    public boolean isFeePaid() {
        return this.feePaid;
    }
    
    /**
     * Sets the feePaid attribute
     * 
     * @param feePaid true if the fee is paid, false otherwise
     */
    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }
}
