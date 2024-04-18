package is.hi.hbv202g.project;

import java.util.List;

/**
 * printText class - prints text to the console
 */
public class printText {
    static LibrarySystem librarySystem;

    /**
     * Prints the choices for the user
     */
    public static void printPrompt() {
        System.out.println("1. Add book");
        System.out.println("2. Add user");
        System.out.println("3. Lend book");
        System.out.println("4. Return book");
        System.out.println("5. List books");
        System.out.println("6. List users");
        System.out.println("7. List books on loan to user");
        System.out.println("8. List overdue books");
        System.out.println("9. List overdue books for user");
        System.out.println("10. Exit");
    }
    
    public static void noString() {
        System.out.println("Please enter a number");
    }
    public static void invalidChoice() {
        System.out.println("Invalid choice");
    }
    public static void returnBook() {
        System.out.println("Return book:");
    }
    public static void userName() {
        System.out.println("Enter the name of the user");
    }
    public static void bookTitle() {
        System.out.println("Enter the title of the book");
    }
    public static void bookAuthor() {
        System.out.println("Enter the name of the author");
    }
    public static void typeOfUser() {
        System.out.println("Enter the type of user (1 for student, 2 for faculty member)");
    }
    public static void department() {
        System.out.println("Enter the department of the faculty member");
    }

    /**
     * Prints a list of books
     */
    public static void printBookList(List<Book> books) {
        System.out.println("Books:");
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    /**
     * Prints a list of overdue books
     */
    public static void booksOverdue() {
        System.out.println("Books that are overdue:");
        for(Lending lending : librarySystem.getLendings()){
            if(lending.isOverdue()){
                System.out.println(lending.getBook().getTitle());
            }
        }
    }

    /**
     * Prints a list of users
     */
    public static void listUsers() {
        System.out.println("Users:");
        for (User user : librarySystem.getUsers()) {
            System.out.println(user.getName());
        }
    }
    
    /**
     * Prints a list of books
     */
    public static void listBooks() {
        List <Book> books = librarySystem.getBooks();
        System.out.println("Number of books: " + books.size());
        printBookList(books);
    }
}
