package is.hi.hbv202g.project;

/**
 * User class - represents a user
 */
public abstract class User {

    private String name;

    /**
     * Constructor
     * 
     * @param name name of the user
     */
    public User(String name) {

        this.name = name;
    }

    /**
     * Returns the name of the user
     * 
     * @return the name of the user
     */
    public String getName() {

        return this.name;
    }

    /**
     * Sets the name of the user
     * 
     * @param name the name of the user
     */
    public void setName(String name) {
        
        this.name = name;
    }
}
