import java.util.ArrayList;
import java.util.Random;

// The Student class represents a college student who can borrow textbooks from the library.
public class Student {
    private String name;
    private Library library;
    private LibraryCard libraryCard;
    private TextBook currentTextBook;

    // Constructor to initialize a new Student object.
    // @param name The name of the student.
    // @param library The library the student joins.
    public Student(String name, Library library) {
        this.name = name;
        this.library = library;
        this.libraryCard = library.issueCard();
        this.currentTextBook = null;
    }

    // Checks if the student has finished studies.
    // @return True if the student does not have a textbook and can't borrow one due to an expired library card, false otherwise.
    public boolean finishedStudies() {
        return (currentTextBook == null && libraryCard.expired());
    }

    // Causes the student to study.
    // If the student does not have a textbook, tries to borrow one from the library.
    // If the student has a textbook and it's not finished, reads one chapter.
    // If the student has a finished textbook, closes and returns it to the library.
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

    // Prints out messages about the student's current state.
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
