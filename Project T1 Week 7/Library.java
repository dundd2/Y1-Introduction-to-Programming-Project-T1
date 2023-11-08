//the Library class represents a library that contains books and issues library cards.
public class Library {
    //fields to store the bookshelf, next book to be borrowed, and number of borrowers.
    private TextBook[] bookShelf;
    private int nextBook;
    private int borrowers;

    //constructor to initialize a new Library object
    public Library(int maxBooks) {
        this.bookShelf = new TextBook[maxBooks];  //The bookshelf can hold up to maxBooks books
        this.nextBook = 0;  //Initially, the next book to be borrowed is the first book
        this.borrowers = 0;  //Initially, there are no borrowers

        //Fill the bookshelf with TextBook objects
        for (int i = 0; i < maxBooks; i++) {
            this.bookShelf[i] = new TextBook("text book " + (i + 1), 10);  //Each book has a unique title and 10 chapters
        }
    }

    //method to issue a new library card
    public LibraryCard issueCard() {
        LibraryCard newCard = new LibraryCard(5, this.borrowers);  //The card has a borrowing limit of 5 and a unique card number
        this.borrowers++;  //Increment the number of borrowers
        return newCard;  //Return the new card
    }

    //method to borrow a book using a library card
    public TextBook borrowBook(LibraryCard card) {
        if (card == null || card.expired() || this.nextBook >= this.bookShelf.length) {
            return null;  //If the card is invalid or there are no books left, return null
        }

        TextBook book = this.bookShelf[this.nextBook];  //Get the next book
        this.bookShelf[this.nextBook] = null;  //Remove the book from the bookshelf
        this.nextBook++;  //Increment the next book to be borrowed
        card.swipe();  //Swipe the card
        return book;  //Return the borrowed book
    }

    //method to return a book to the library.
    public void returnBook(TextBook book) {
        if (this.nextBook > 0 && this.bookShelf[this.nextBook - 1] == null) {
            this.bookShelf[this.nextBook - 1] = book;  //If there is space, put the book back on the bookshelf
            this.nextBook--;  //Decrement the next book to be borrowed
        }
    }

    //method to print a description of the library
    public void describe() {
        int booksLeft = this.bookShelf.length - this.nextBook;  //Calculate the number of books left on the bookshelf
        System.out.println("The library has " + booksLeft + " books left on the shelf and has issued " + this.borrowers + " library cards");  //Print the description
    }
}
