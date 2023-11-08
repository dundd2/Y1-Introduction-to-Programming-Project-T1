//the TextBook class represents a textbook in the library
public class TextBook {
    //fields to store the title, length, and last chapter read of the book
    private String title;
    private int length;
    private int lastChapterRead;

    //constructor to initialize a new TextBook object
    public TextBook(String title, int length) {
        this.title = title;
        this.length = length;
        this.lastChapterRead = 0;  //Initially, no chapters have been read
    }

    //method to get the title of the book
    public String getTitle() {
        return this.title;
    }

    //method to 'read' the next chapter of the book
    public void readNextChapter() {
        if (this.lastChapterRead < this.length) {
            this.lastChapterRead++;  //If there are chapters left,increment lastChapterRead
        } else {
            System.out.println("Warning: No more chapters left to read!");  //Otherwise, print a warning
        }
    }

    //method to check if the book is finished
    public boolean isFinished() {
        return this.lastChapterRead == this.length;  //The book is finished if all chapters have been read
    }

    //method to 'close' the book, resetting it to its initial state
    public void closeBook() {
        this.lastChapterRead = 0;  //Reset lastChapterRead to 0
    }

    //method to print a description of the book
    public void describe() {
        int chaptersLeft = this.length - this.lastChapterRead;  //Calculate the number of chapters left
        System.out.println(this.title + " with " + chaptersLeft + " chapters left to read");  //Print the description
    }
}
