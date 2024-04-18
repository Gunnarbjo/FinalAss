package is.hi.hbv202g.project;

import java.time.LocalDate;


/**
 * Lending class - represents a lending of a book to a user
 */
public class Lending {

    private static final int LENDING_PERIOD = 30;
    private LocalDate dueDate;
    private Book book;
    private User user;

    /**
     * Constructor
     * 
     * @param book book to be lent
     * @param user user to lend the book to
     */
    public Lending(Book book, User user){
        
        this.dueDate = LocalDate.now().plusDays(LENDING_PERIOD);
        this.book = book;
        this.user = user;
    }

    /**
     * Get the due date of the lending
     * 
     * @return due date
     */
    public LocalDate getDueDate() {
        return this.dueDate;
    }

    /**
     * Set the due date of the lending
     * 
     * @param dueDate due date
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Get the book of the lending
     * 
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     * Set the book of the lending
     * 
     * @param book book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Get the user of the lending
     * 
     * @return user
     */
    public User getUser() {
        return user;
    }
    
    /**
     * Set the user of the lending
     * 
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Check if the lending is overdue
     * 
     * @return true if the lending is overdue, false otherwise
     */
    public boolean isOverdue(){
        return LocalDate.now().isAfter(dueDate);
    }

}
