/**  
 * Represents a textbook in the library
 * @author  Duncan
 * @version 29-11-2023
 */
public class TextBook {

    /** Title of the textbook */
    private String title;

    /** Number of chapters */
    private int length;

    /** Last chapter read */ 
    private int lastChapterRead;

    /**
     * Constructor to initialize new TextBook
     * @param title Title of book
     * @param length Number of chapters  
     */
    public TextBook(String title, int length) {
        this.title = title;
        this.length = length;
        this.lastChapterRead = 0;  
    }

    /**
     * Gets the book title  
     * @return Title as string
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Reads the next chapter 
     */
    public void readNextChapter() {
        if (this.lastChapterRead < this.length) {
            this.lastChapterRead++;  
        } else {
            System.out.println("Warning: No more chapters left to read!");
        }
    }

    /**
     * Checks if all chapters read
     * @return True if all read, false otherwise  
     */
    public boolean isFinished() {
        return this.lastChapterRead == this.length;
    }

    /**
     * Resets a finished book to initial unused state
     */
    public void closeBook() {
        this.lastChapterRead = 0;
    }

    /** 
     * Prints description of book state 
     */
    public void describe() {
        int chaptersLeft = this.length - this.lastChapterRead;
        System.out.println(this.title + " with " + chaptersLeft + " chapters left to read");
    }

    /**
     * Gets number of chapters left
     * @return Chapters left
     */
    public int getChaptersLeft() {
        return this.length - this.lastChapterRead;
    }
}