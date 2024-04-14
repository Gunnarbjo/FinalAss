package is.hi.hbv202g.assignment8;

import java.util.List;
import java.util.ArrayList;

/**
 * Book class - represents a book with a title and a list of authors
 */
public class Book {

    private String title;
    private List<Author> authors = new ArrayList<Author>();

    /**
     * Constructor
     * 
     * @param title title of the book
     * @param authorName name of the author
     */
    public Book(String title, String authorName) {

        this.title = title;
        this.authors.add(new Author(authorName));
    }

    /**
     * Constructor
     * 
     * @param title title of the book
     * @param authorList list of authors
     */
    public Book(String title, List<Author> authorList) throws EmptyAuthorListException{

        this.title = title;
        if(authorList.isEmpty()){
            throw new EmptyAuthorListException("No authors found for book" + this.title);
        }
        this.authors = authorList;
    }

    /**
     * Get the authors of the book
     * 
     * @return list of authors
     */
    public List<Author> getAuthors(){ 

        return this.authors;
     }

    /**
     * Set the authors of the book
     * 
     * @param authors list of authors
     * @throws EmptyAuthorListException if the list of authors is empty
    */
    public void setAuthors(List<Author> authors) throws EmptyAuthorListException{

        if(authors.isEmpty()){
            throw new EmptyAuthorListException("Author list is empty");
        }
        this.authors = authors;
    }

    /**
     * Add an author to the book
     * 
     * @param author author to add
     */
    public void addAuthor(Author author){
        this.authors.add(author);
        
    }

    /**
     * Get the title of the book
     * 
     * @return title of the book
     */
    public String getTitle(){
        return this.title;
    }
    
    /**
     * Set the title of the book
     * 
     * @param title title of the book
     */
    public void setTitle(String title){
        this.title = title;
    }
}
