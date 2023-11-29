import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class StudentTest.
 *
 * @author  Duncan
 * @version 29-11-2023
 */
public class StudentTest
{
    private Library library;
    private Student student;

    @BeforeEach
    public void setUp()
    {
        library = new Library(5); // You might want to adjust the number of books
        student = new Student("TestStudent", library);
    }

    @AfterEach
    public void tearDown()
    {
        library = null;
        student = null;
    }

    @Test
    public void testFinishedStudiesWithoutBookAndExpiredCard() {
        assertTrue(student.finishedStudies());
    }

    @Test
    public void testFinishedStudiesWithBookAndExpiredCard() {
        student.study(); // Borrow a book
        // Simulate the card being expired
        LibraryCard expiredCard = new LibraryCard(0, 0);
        assertTrue(student.finishedStudies());

    }

    @Test
    public void testStudyMethod() {
        student.study(); // Borrow a book
        student.study(); // Read one chapter
        student.study(); // Finish the book
        assertFalse(student.finishedStudies()); // Should be false after finishing the book
    }

    @Test
    public void testDescribeMethod() {
        student.study(); // Borrow a book
        student.describe(); // For demonstration purposes, print student state
    }
}
