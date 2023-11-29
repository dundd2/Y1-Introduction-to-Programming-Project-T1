/**
 * The Student class represents a college student who can borrow textbooks from the library.
 * @author  Duncan
 * @version 29-11-2023
 */
public class Student {

    /** The name of the student */
    private String name;

    /** The library the student joins */
    private Library library;

    /** The student's library card */
    private LibraryCard libraryCard;

    /** The textbook currently borrowed by student */
    private TextBook currentTextBook;

    /**
     * Constructor to initialize a new Student object.
     * @param name The name of the student
     * @param library The library the student joins
     */
    public Student(String name, Library library) {
        this.name = name;
        this.library = library;
        this.libraryCard = library.issueCard();
        this.currentTextBook = null;
    }

    /** 
     * Checks if the student has finished studies.
     * @return True if student does not have a textbook and library card expired, false otherwise
     */
    public boolean finishedStudies() {
        return (currentTextBook == null && libraryCard.expired()); 
    }

    /**
     * Causes the student to study:
     * - If no textbook, tries to borrow one  
     * - If has textbook, reads one chapter
     * - If textbook finished, returns it
     */
    public void study() {
        if (currentTextBook == null) {
            currentTextBook = library.borrowBook(libraryCard);
        } else if (!currentTextBook.isFinished()) {
            currentTextBook.readNextChapter();
        } else {
            currentTextBook.closeBook();
            library.returnBook(currentTextBook);
            currentTextBook = null;
        }
    }

    /**
     * Prints out messages about the student's current state
     */
    public void describe() {
        System.out.println("Student " + name + " " + getDescription()); 
    }

    private String getDescription() {
        if (currentTextBook == null) {
            return "does not have a book and " + libraryCard.getDescription();
        } else {
            return "has a book " + currentTextBook.getTitle() + " with " + currentTextBook.getChaptersLeft() + 
            " chapters left.\nThe student is " + (currentTextBook.isFinished() ? "not reading" : "reading the book.");
        }
    }
}