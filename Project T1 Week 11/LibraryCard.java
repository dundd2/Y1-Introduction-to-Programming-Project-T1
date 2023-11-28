/**
 * Represents a library card used to borrow books  
 * @author duncan
 * @version 1.0
*/
class LibraryCard {

    /** Borrowing limit */
    private int limit;
    
    /** Number of books borrowed */ 
    private int borrowed;
    
    /** Card reference ID */
    private String cardRef;

    /**
     * Constructor to initialize a new LibraryCard  
     * @param limit Borrowing limit
     * @param cardNum Card number
     */
    public LibraryCard(int limit, int cardNum) {
        this.limit = limit;
        this.borrowed = 0;  
        this.cardRef = "cardID " + cardNum;  
    }

    /**
     * Increments number of books borrowed 
     */
    public void swipe() {
        this.borrowed++;
    }

    /**
     * Checks if card borrowing limit reached 
     * @return True if limit reached, false otherwise
     */
    public boolean expired() {
        return this.borrowed >= this.limit;  
    }

      /**
     * Gets description of card state  
     * @return Description with books left 
     */
    public String getDescription() {
        int booksLeft = this.limit - this.borrowed;
        return "Library card " + this.cardRef + " with " + booksLeft + " books left";
    }
}