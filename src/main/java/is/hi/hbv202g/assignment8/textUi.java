package is.hi.hbv202g.assignment8;

import java.util.List;
import java.util.Scanner;

/**
 * textUi class - handles the text user interface
 */
public class textUi {

    private Scanner scanner = new Scanner(System.in);
    private LibrarySystem librarySystem;

    /**
     * Constructor
     * 
     * @param myLibrarySystem the library system
     */
	public textUi(LibrarySystem myLibrarySystem) {
        librarySystem = myLibrarySystem;
        printText.librarySystem = myLibrarySystem;
        addInitialData();
    }
    public LibrarySystem getLibrarySystem() {
        return librarySystem;
    }

    /**
     * Prints the choices for the user
     */
    public void getPrompt() {
        prompt();
    }

    /**
     * The main loop of the text user interface
     */
    private void prompt(){

        while(true){
            int choice = 0;
            printText.printPrompt();
            try{
                choice = scanner.nextInt();
                scanner.nextLine();
                pickChoice(choice);
            }catch(Exception e){
                printText.noString();
                scanner.nextLine();
            }
            scanner.nextLine();
            clearScreen();
        }

    }

    /**
     * Picks the choice of the user
     * 
     * @param choice the choice of the user
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    private void pickChoice(int choice) throws UserOrBookDoesNotExistException {
        switch(choice){
        case 1:
            addBook();
            break;
        case 2:
            addUser();
            break;
        case 3:
            lendBook();
            break;
        case 4:
            returnBook();
            break;
        case 5:
            listBooks();
            break;
        case 6:
            listUsers();
            break;
        case 7:
            listBooksOnLoanToUser();
            break;
        case 8:
            listOverdueBooks();
            break;
        case 9:
            listOverdueBooksForUser();
            break;
        case 10:
            scanner.close();
            System.exit(0);
            break;
        default:
            printText.invalidChoice();
            break;
        }
    }

    /**
     * Lists the books that are overdue for a user
     * 
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    private void listOverdueBooksForUser() throws UserOrBookDoesNotExistException {
        clearScreen();
        printText.userName();
        String name = scanner.nextLine();
        List<Book> books = librarySystem.overdueForUser(name);
        printText.printBookList(books);

    }

    /**
     * Lists the books that are on loan to a user
     * 
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    private void listBooksOnLoanToUser() throws UserOrBookDoesNotExistException{
        clearScreen();
        printText.userName();
        String name = scanner.nextLine();
        List<Book> books = librarySystem.booksOnLoanToUser(name);
        printText.printBookList(books);

    }
    
    /**
     * Returns a book from a user
     * 
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    private void returnBook() throws UserOrBookDoesNotExistException{
        clearScreen();
        printText.returnBook();
        printText.userName();
        String name = scanner.nextLine();
        printText.bookTitle();
        String title = scanner.nextLine();
        librarySystem.returnBookFromUser(name, title);
    }

    /**
     * Lists the books that are overdue
     */
    private void listOverdueBooks() {
        clearScreen();
        printText.booksOverdue();

    }

    /**
     * Lists all users
     */
    private void listUsers() {        
        clearScreen();
        printText.listUsers();
    }

    /**
     * Lists all books
     */
    private void listBooks() {
        clearScreen();
        printText.listBooks();
    }


    /**
     * Lends a book to a user
     * 
     * @throws UserOrBookDoesNotExistException if the user or book does not exist
     */
    private void lendBook() throws UserOrBookDoesNotExistException{
        clearScreen();
        printText.userName();
        String name = scanner.nextLine();
        printText.bookTitle();
        String title = scanner.nextLine();
        librarySystem.lendBookToUser(name, title);
    }

    /**
     * Adds a user to the library system
     */
    private void addUser() {
        clearScreen();
        printText.userName();
        String name = scanner.nextLine();
        printText.typeOfUser();
        int type = scanner.nextInt();
        scanner.nextLine();

        if(type == 1){
            librarySystem.addStudentUser(name, true);
        }else if(type == 2){ 
            printText.department();
            String department = scanner.nextLine();        
            librarySystem.addFacultyMemberUser(name, department);
        }
        else{
            printText.invalidChoice();
        }
    }

    /**
     * Adds a book to the library system
     */
    public void addBook() {
        clearScreen();
        printText.bookTitle();
        String title = scanner.nextLine();
        printText.bookAuthor();
        String authorName = scanner.nextLine();
        librarySystem.addBook(title, authorName);

    }

    /**
     * Clears the screen
     */
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Adds inital data to the library system
     */
    private void addInitialData() {
        try {
            // Adding books
            librarySystem.addBook("1984", "George Orwell");
            librarySystem.addBook("Brave New World", "Aldous Huxley");
            librarySystem.addBook("Fahrenheit 451", "Ray Bradbury");
            librarySystem.addBook("Dune", "Frank Herbert");
            librarySystem.addBook("Neuromancer", "William Gibson");
            librarySystem.addBook("Snow Crash", "Neal Stephenson");
            librarySystem.addBook("The Left Hand of Darkness", "Ursula K. Le Guin");
            librarySystem.addBook("Hyperion", "Dan Simmons");
            librarySystem.addBook("Foundation", "Isaac Asimov");
    
            librarySystem.addBook("American Gods", List.of(new Author("Neil Gaiman")));
            librarySystem.addBook("Blindsight", List.of(new Author("Peter Watts")));
            librarySystem.addBook("The Expanse", List.of(new Author("James S.A. Corey")));
    
            // Adding students
            librarySystem.addStudentUser("Harry Potter", true);
            librarySystem.addStudentUser("Hermione Granger", true);
            librarySystem.addStudentUser("Ron Weasley", true);
            librarySystem.addStudentUser("Neville Longbottom", false);
    
            // Adding faculty
            librarySystem.addFacultyMemberUser("Albus Dumbledore", "Wizard");
            librarySystem.addFacultyMemberUser("Severus Snape", "Potions Master");
            librarySystem.addFacultyMemberUser("Minerva McGonagall", "Witch");
            librarySystem.addFacultyMemberUser("Rincewind", "Wizard");
    
            // Borrowing books
            librarySystem.borrowBook(
                librarySystem.findStudentByName("Harry Potter"),
                librarySystem.findBookByTitle("1984"));
    
            librarySystem.borrowBook(
                librarySystem.findFacultyMemberByName("Minerva McGonagall"),
                librarySystem.findBookByTitle("The Left Hand of Darkness"));
    
            librarySystem.borrowBook(
                librarySystem.findFacultyMemberByName("Albus Dumbledore"),
                librarySystem.findBookByTitle("Fahrenheit 451"));
    
            // Extending lending
            librarySystem.extendLending(
                (FacultyMember) librarySystem.findFacultyMemberByName("Severus Snape"),
                librarySystem.findBookByTitle("Brave New World"),
                java.time.LocalDate.now().plusDays(30));
    
            // Returning books
            librarySystem.returnBook(
                librarySystem.findStudentByName("Harry Potter"),
                librarySystem.findBookByTitle("1984"));
    
        } catch (UserOrBookDoesNotExistException | EmptyAuthorListException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
}
