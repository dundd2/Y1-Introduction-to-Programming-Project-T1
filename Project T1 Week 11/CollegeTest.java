import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CollegeTest.
 *
 * @author  Duncan
 * @version 29-11-2023
 */
public class CollegeTest
{
    private College college;
    
    @BeforeEach
    public void setUp()
    {
        college = new College(5, 3); // Adjust the number of students and books
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        college = null;
    }

    @Test
    public void testDescribeMethod() {
        college.describe(); // For demonstration purposes, print college state
    }

    @Test
    public void testNextStepMethod() {
        college.runCollege(1); // Run one step
        college.describe(); // For demonstration purposes, print college state
    }

    @Test
    public void testRunCollegeMethod() {
        college.runCollege(3); // Run for three steps
        college.describe(); // For demonstration purposes, print college state
    }
}
