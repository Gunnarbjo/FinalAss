package is.hi.hbv202g.project;

/**
 * Main class - runs the library system
 */
public class Main
{
    /**
     * Main method - runs the library system
     * 
     * @param args command line arguments
     */
    public static void main( String[] args )
    {
        LibrarySystem myLibrarySystem = new LibrarySystem();
        textUi myInterface = new textUi(myLibrarySystem);
        myInterface.getPrompt();
    }
}
