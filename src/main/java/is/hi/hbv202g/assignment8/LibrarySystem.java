package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * LibrarySystem class - represents a library system with books, users and lendings
 */
public class LibrarySystem {

    private List<Book> books;
    private List<User> users;
    private List<Lending> lendings;

    /**
     * Constructor
     */
    public LibrarySystem(){

        books = new ArrayList<>();
        users = new ArrayList<>();
        lendings = new ArrayList<>();   
    
    }

    /**
     * Add a book with a title and the name of a single author
     * 
     * @param title title of the book
     * @param authorName name of the author
     * @throws EmptyAuthorListException 
     */
    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName){
        this.books.add(new Book(title, authorName));
    }


    /**
     * Add a book with a title and a list of authors
     * 
     * @param title title of the book
     * @param authors list of authors
     * @throws EmptyAuthorListException if the list of authors is empty
     */
    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException{

        this.books.add(new Book(title, authors));     
        if(authors.isEmpty()){
            throw new EmptyAuthorListException("Author list is empty");
        }   
    }

    /**
     * Add a student user
     * 
     * @param name name of the student
     * @param feePaid true if the fee is paid, false otherwise
     */
    public void addStudentUser(String name, boolean feePaid){

        this.users.add(new Student(name, feePaid));
    }

    /**
     * Add a faculty member user
     * 
     * @param name name of the faculty member
     * @param department department of the faculty member
     */
    public void addFacultyMemberUser(String name, String department){
      
        this.users.add(new FacultyMember(name, department));
    }
    
    /**
     * Find a book by title
     * 
     * @param title title of the book
     * @return book
     * @throws UserOrBookDoesNotExistException if the book does not exist
     */
    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException{

        for (Book book : this.books){
            if (book.getTitle().equals(title)){
                return book;
            }
        }throw new UserOrBookDoesNotExistException("Book " + title + " not found");
    }

    /**
     * Find a user by name
     * 
     * @param name name of the user
     * @return user
     * @throws UserOrBookDoesNotExistException if the user does not exist
     */
    public Student findStudentByName(String name) throws UserOrBookDoesNotExistException{
            for (User user : this.users){
                if (user.getName().equals(name) && checkIfUserIsStudent(user)){
                    return (Student) user;
                }
            }throw new UserOrBookDoesNotExistException("Student " + name + " not found");
        }

    /**
     * Find a user by name
     * 
     * @param name name of the user
     * @return user
     * @throws UserOrBookDoesNotExistException if the user does not exist
     */
    public FacultyMember findFacultyMemberByName(String name) throws UserOrBookDoesNotExistException{
        for (User user : this.users){
            if (user.getName().equals(name) && checkIfUserIsFacultyMember(user)){
                return (FacultyMember) user;
            }
        }throw new UserOrBookDoesNotExistException("Faculty member " + name + " not found");
    }

    /**
     * Find a user by name
     * 
     * @param name name of the user
     * @return user
     * @throws UserOrBookDoesNotExistException if the user does not exist
     */
    private boolean checkIfUserIsFacultyMember(User user){
        return user instanceof FacultyMember;
    }

    /**
     * Find a user by name
     * 
     * @param name name of the user
     * @return user
     * @throws UserOrBookDoesNotExistException if the user does not exist
     */
    private boolean checkIfUserIsStudent(User user){
        return user instanceof Student;
    }

    /**
     * Borrow a book
     * 
     * @param user user borrowing the book
     * @param book book to borrow
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException{

        for(Lending lending : this.lendings){
            if(lending.getBook().equals(book)){
                throw new UserOrBookDoesNotExistException("Lending already exists");
            }
        }
        lendings.add(new Lending(book, user));
    }

    /**
     * Extend the lending of a book
     * 
     * @param facultyMember faculty member borrowing the book
     * @param book book to extend the lending of
     * @param newDueDate new due date
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) throws UserOrBookDoesNotExistException{

        for(Lending lending : this.lendings){
            if(lending.getBook().equals(book) && lending.getUser().equals(facultyMember)){
                lending.setDueDate(newDueDate);
                return;
            }
        }
        throw new UserOrBookDoesNotExistException("Lending does not exist");
    }

    /**
     * Return a book
     * 
     * @param user user returning the book
     * @param book book to return
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException{

        Iterator<Lending> iterator = lendings.iterator();
        while(iterator.hasNext()){
            Lending lending = iterator.next();
            if(lending.getBook().equals(book) && lending.getUser().equals(user)){
                iterator.remove();
                return;
            }
        }
        throw new UserOrBookDoesNotExistException("Lending does not exist");  
    }

    /**
     * Get the lendings
     * 
     * @return list of lendings
     */
    public List<Lending> getLendings() {
        return new ArrayList<>(lendings);
    }

    /**
     * Get the users
     * 
     * @return list of users
     */
    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    /**
     * Get the books
     * 
     * @return list of books
     */
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Get the books that are overdue for a user
     * 
     * @param name name of the user
     * @return list of overdue books
     * @throws UserOrBookDoesNotExistException if the user does not exist
     */
    public List<Book> overdueForUser(String name) throws UserOrBookDoesNotExistException{
        List<Book> overdueBooks = new ArrayList<>();
        User user = findUserByName(name);
        for(Lending lending : this.lendings){
            if(lending.getUser().equals(user) && lending.isOverdue()){
                overdueBooks.add(lending.getBook());
            }
        }
        return overdueBooks;
    }

    public User findUserByName(String name) throws UserOrBookDoesNotExistException{
        for (User user : this.users){
            if (user.getName().equals(name)){
                return user;
            }
        }
        throw new UserOrBookDoesNotExistException("User " + name + " not found");
    }
    /**
     * Get the books that are on loan to a user
     * 
     * @param name name of the user
     * @return list of books on loan
     * @throws UserOrBookDoesNotExistException if the user does not exist
     */
    public List<Book> booksOnLoanToUser(String name) throws UserOrBookDoesNotExistException{
        List<Book> booksOnLoan = new ArrayList<>();
        User user = findUserByName(name);
        for(Lending lending : this.lendings){
            if(lending.getUser().equals(user)){
                booksOnLoan.add(lending.getBook());
            }
        }
        return booksOnLoan;
    }

    /**
     * Return a book from a user
     * 
     * @param name name of the user
     * @param title title of the book
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    public void returnBookFromUser(String name, String title) throws UserOrBookDoesNotExistException{
            
            User user = findUserByName(name);
            Book book = findBookByTitle(title);
            returnBook(user, book);
            throw new UserOrBookDoesNotExistException("User or book does not exist");
    }

    /**
     * Lend a book to a user
     * 
     * @param name name of the user
     * @param title title of the book
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    public void lendBookToUser(String name, String title) throws UserOrBookDoesNotExistException{

            User user = findUserByName(name);
            Book book = findBookByTitle(title);
            borrowBook(user, book);
            throw new UserOrBookDoesNotExistException("User or book does not exist");
    }

    /**
     * get current borrower of book
     * 
     * @param title title of the book
     */
    public User getCurrentBorrower(String title) throws UserOrBookDoesNotExistException{
        Book book = findBookByTitle(title);
        for(Lending lending : this.lendings){
            if(lending.getBook().equals(book)){
                return lending.getUser();
            }
        }
        throw new UserOrBookDoesNotExistException("Book " + title + " is not on loan");
    }
    
}
