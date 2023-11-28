/**
 * Represents a library containing books   
 * @author duncan
 * @version 1.0  
*/
public class Library {

    /** Array holding available textbooks */
    private TextBook[] bookShelf;
    
    /** Index of next book to lend out */
    private int nextBook;
    
    /** Number of active borrowers */ 
    private int borrowers;

    /**
     * Constructor to initialize a new Library
     * @param maxBooks Max capacity of books
     */
    public Library(int maxBooks) {
        this.bookShelf = new TextBook[maxBooks];  
        this.nextBook = 0;  
        this.borrowers = 0;  

        for (int i = 0; i < maxBooks; i++) {
            this.bookShelf[i] = new TextBook("text book " + (i + 1), 10);  
        }
    }

    /**
     * Issues new library card
     * @return The new library card
     */
    public LibraryCard issueCard() {
        LibraryCard newCard = new LibraryCard(5, this.borrowers);  
        this.borrowers++;  
        return newCard;
    }

    /**
     * Borrows book using given library card
     * @param card The library card
     * @return The borrowed textbook, null if invalid card or no books left
     */
    public TextBook borrowBook(LibraryCard card) {
        if (card == null || card.expired() || this.nextBook >= this.bookShelf.length) {
            return null;  
        }

        TextBook book = this.bookShelf[this.nextBook]; 
        this.bookShelf[this.nextBook] = null;  
        this.nextBook++;  
        card.swipe();  
        return book;   
    }

    /**
     * Returns a book to the library 
     * @param book The textbook to return
     */
    public void returnBook(TextBook book) {
        if (this.nextBook > 0 && this.bookShelf[this.nextBook - 1] == null) {
            this.bookShelf[this.nextBook - 1] = book;  
            this.nextBook--;
        }
    }

    /**
     * Prints out description of library state  
     */
    public void describe() {
        int booksLeft = this.bookShelf.length - this.nextBook;  
        System.out.println("The library has " + booksLeft + " books left on the shelf and has issued " + this.borrowers + " library cards");
    }
}