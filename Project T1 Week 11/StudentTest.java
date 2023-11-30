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
        library = new Library(5);
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
        LibraryCard expiredCard = new LibraryCard(0, 0);
        student.setLibraryCard(expiredCard);
        assertTrue(student.finishedStudies());
    }

    @Test
    public void testFinishedStudiesWithBookAndExpiredCard() {
        LibraryCard expiredCard = new LibraryCard(0, 0);
        student.setLibraryCard(expiredCard);
        student.study();
        assertTrue(student.finishedStudies());
    }

    @Test
    public void testStudyMethod() {
        student.study(); 
        student.study(); 
        student.study();
        assertFalse(student.finishedStudies()); 
    }

    @Test
    public void testDescribeMethod() {
        student.study(); 
        student.describe(); 
    }
}
