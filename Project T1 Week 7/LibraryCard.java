//the LibraryCard class represents a library card that can be used to borrow books
public class LibraryCard {
    //fields to store the borrowing limit, number of books borrowed, and card reference
    private int limit;
    private int borrowed;
    private String cardRef;

    //constructor to initialize a new LibraryCard object
    public LibraryCard(int limit, int cardNum) {
        this.limit = limit;
        this.borrowed = 0;  //Initially, no books have been borrowed.
        this.cardRef = "cardID " + cardNum;  //The card reference is "cardID " followed by the card number
    }

    //method to 'swipe' the card, increasing the number of books borrowed
    public void swipe() {
        this.borrowed++;
    }

    //method to check if the card has expired
    public boolean expired() {
        return this.borrowed >= this.limit;  //The card has expired if the borrowing limit has been reached
    }

    //method to get the card reference
    public String getCardRef() {
        return this.cardRef;
    }

    //method to print a description of the card
    public void describe() {
        int booksLeft = this.limit - this.borrowed;  //Calculate the number of books left that can be borrowed
        System.out.println("Library card " + this.cardRef + " with " + booksLeft + " books left");  //Print the description
    }
}