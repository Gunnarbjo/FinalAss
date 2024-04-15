package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class LibrarySystemTest {
    
    private LibrarySystem librarySystem;

    /*
     * Test if a library system can be created
     */
    @Before
    public void testCreateLibrarySystem() {
        librarySystem = new LibrarySystem();
    }

    /*
     * Test addBookWithTitleAndNameOfSingleAuthor
     */
    @Test
    public void testAddBookWithTitleAndNameOfSingleAuthor() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        assert(librarySystem.findBookByTitle("The Hobbit").getTitle().equals("The Hobbit"));
    }
    /*
     * Test addBookWithTitleAndAuthorList
     */ 
    @Test
    public void testAddBookWithTitleAndAuthorList() throws UserOrBookDoesNotExistException, EmptyAuthorListException{
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("J.R.R. Tolkien"));
        librarySystem.addBook("The Hobbit", authors);
        assert(librarySystem.findBookByTitle("The Hobbit").getTitle().equals("The Hobbit"));
    }
    /*
     * Test addStudentUser
     */
    @Test
    public void testAddStudentUser() throws UserOrBookDoesNotExistException{
        librarySystem.addStudentUser("Jón Jónsson", true);
        assert(librarySystem.findStudentByName("Jón Jónsson").getName().equals("Jón Jónsson"));
    }
    /*
     * Test addFacultyMemberUser
     */
    @Test
    public void testAddFacultyMemberUser() throws UserOrBookDoesNotExistException{
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        assert(librarySystem.findFacultyMemberByName("Jón Jónsson").getName().equals("Jón Jónsson"));
    }
    /*
     * Test findBookByTitle
     */
    @Test
    public void testFindBookByTitle() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        assert(librarySystem.findBookByTitle("The Hobbit").getTitle().equals("The Hobbit"));
    }
    /*
     * Test not finding a book by title
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testFindBookByTitleException() throws UserOrBookDoesNotExistException{
        librarySystem.findBookByTitle("The Hobbit");
    }
    /*
     * Test findUserByName
     */
    @Test
    public void testFindUserByName() throws UserOrBookDoesNotExistException{
        librarySystem.addStudentUser("Jón Jónsson", true);
        assert(librarySystem.findUserByName("Jón Jónsson").getName().equals("Jón Jónsson"));
    }
    /*
     * Test not finding a user by name
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testFindUserByNameException() throws UserOrBookDoesNotExistException{
        librarySystem.findUserByName("Jón Jónsson");
    }
    /*
     * Test borrowBook
     */
    @Test
    public void testBorrowBook() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
    }
    /*
     * Test borrowing a book that is already borrowed
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testBorrowBookException() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
    }
    /*
     * Test borrowing a book that does not exist
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testBorrowBookException2() throws UserOrBookDoesNotExistException{
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
    }
    /*
     * Test extendLending
     */
    @Test
    public void testExtendLending() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findFacultyMemberByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        librarySystem.extendLending(librarySystem.findFacultyMemberByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"), LocalDate.now().plusDays(10));
    }
    /*
     * Test extending a lending that does not exist
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testExtendLendingException() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.extendLending(librarySystem.findFacultyMemberByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"), LocalDate.now().plusDays(10));
    }
    /*
     * Test extending a lending that is not borrowed by the user
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testExtendLendingException2() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.addFacultyMemberUser("Jón Jónsson2", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        librarySystem.extendLending(librarySystem.findFacultyMemberByName("Jón Jónsson2"), librarySystem.findBookByTitle("The Hobbit"), LocalDate.now().plusDays(10));
    }

    /*
     * Test extending a lending that is borrowed by a faculty member
     */ 
    @Test
    public void testExtendLending2() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        librarySystem.extendLending(librarySystem.findFacultyMemberByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"), LocalDate.now().plusDays(10));
    }
    /*
     * Test extending a lending that is overdue
     */
    @Test
    public void testExtendLending3() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        librarySystem.extendLending(librarySystem.findFacultyMemberByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"), LocalDate.now().minusDays(10));
    }

    /*
     * Test returning a book
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testReturnBook() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        librarySystem.returnBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        librarySystem.getCurrentBorrower("The Hobbit");    }
    /*
     * Test returning a book that is not borrowed
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testReturnBookException() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.returnBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
    }
    /*
     * Test returning a book that does not exist
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testReturnBookException2() throws UserOrBookDoesNotExistException{
        librarySystem.addFacultyMemberUser
        ("Jón Jónsson", "Tölvunarfræði");
        librarySystem.returnBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
    }
    /*
     * Test returning a book that is borrowed by a student
     */
    @Test
    public void testReturnBookException3() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addStudentUser("Jón Jónsson", true);
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        librarySystem.returnBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
    }
    /*
     * Test returning a book that is borrowed by a faculty member
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testReturnBook2() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        librarySystem.returnBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        librarySystem.getCurrentBorrower("The Hobbit");
    }
    /*
     * Test getBooks
     */
    @Test
    public void testGetBooks() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        assert(librarySystem.getBooks().size() == 1);
    }
    /*
     * Test getUsers
     */
    @Test
    public void testGetUsers() throws UserOrBookDoesNotExistException{
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        assert(librarySystem.getUsers().size() == 1);
    }
    /*
     * Test getLendings
     */
    @Test
    public void testGetLendings() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        assert(librarySystem.getLendings().size() == 1);
    }

    /*
     * Test overdueForUser
     */
    @Test
    public void testOverdueForUser() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        assert(librarySystem.overdueForUser("Jón Jónsson").size() == 0);
    }
    /*
     * Test booksOnLoanToUser
     */
    @Test
    public void testBooksOnLoanToUser() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        assert(librarySystem.booksOnLoanToUser("Jón Jónsson").size() == 1);
    }
    /*
     * Test returnBookFromUser
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testReturnBookFromUser() throws UserOrBookDoesNotExistException{
        librarySystem.addBook("The Hobbit", "J.R.R. Tolkien");
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.borrowBook(librarySystem.findUserByName("Jón Jónsson"), librarySystem.findBookByTitle("The Hobbit"));
        librarySystem.returnBookFromUser("Jón Jónsson", "The Hobbit");
        assert(librarySystem.findBookByTitle("The Hobbit").equals(null));
    }
    /*
     * Test returnBookFromUser that does not exist
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testReturnBookFromUserException() throws UserOrBookDoesNotExistException{
        librarySystem.returnBookFromUser("Jón Jónsson", "The Hobbit");
    }
    /*
     * Test lendBookToUser
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testLendBookToUser() throws UserOrBookDoesNotExistException, EmptyAuthorListException{
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("J.R.R. Tolkien"));
        authors.add(new Author("Jón Jónsson"));
        librarySystem.addBook("The Hobbit", authors);
        librarySystem.addFacultyMemberUser("Jón Jónsson", "Tölvunarfræði");
        librarySystem.lendBookToUser("Jón Jónsson", "The Hobbit");
    }
    /*
     * Test lendBookToUser that does not exist
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testLendBookToUserException() throws UserOrBookDoesNotExistException{
        librarySystem.lendBookToUser("Jón Jónsson", "The Hobbit");
    }

}
