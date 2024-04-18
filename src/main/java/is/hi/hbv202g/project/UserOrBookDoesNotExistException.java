package is.hi.hbv202g.project;

/**
 * UserOrBookDoesNotExistException class - represents an exception when the user or book does not exist
 */
public class UserOrBookDoesNotExistException extends Exception{
    /**
     * Constructor
     * 
     * @param message the message of the exception
     */
    public UserOrBookDoesNotExistException(String message) {
        super(message);
    }
}
