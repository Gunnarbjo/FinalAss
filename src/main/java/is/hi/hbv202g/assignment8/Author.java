package is.hi.hbv202g.assignment8;

/**
 * Author class - represents an author of a book
 */
public class Author {

    private String name;

    /**
     * Constructor
     * 
     * @param name name of the author
     */
    public Author(String name) {
        this.name = name;        
    }

    /**
     * Get the name of the author
     * 
     * @return name of the author
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Set the name of the author
     * 
     * @param name name of the author
     */
    public void setName(String name) {
        this.name = name;        
    }
}
