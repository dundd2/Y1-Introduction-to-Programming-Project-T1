import java.util.ArrayList;
import java.util.Random;

/**
 * The College class simulates a college with a library and students. 
 * @author dncan
 * @version 1.0 
*/  
public class College {

    /** List of enrolled students */
    private ArrayList<Student> students;
    
    /** The college library */
    private Library library;
    
    /** Random number generator */
    private Random random;

    /**
     * Constructor to initialize a new College object.
     * @param numStudents Number of enrolled students   
     * @param numBooks Number of textbooks in library  
     */
    public College(int numStudents, int numBooks) {
        this.students = new ArrayList<>();
        this.library = new Library(numBooks);
        this.random = new Random();

        for (int i = 1; i <= numStudents; i++) {
            students.add(new Student("Student" + i, library)); 
        }
    }

    /**
     * Prints a simple description of the college state
     */
    public void describe() {
        System.out.println("The college currently has " + students.size() + " hard-working students");
        library.describe();
    }

    /**
     * Advances the simulation by one step:  
     * - Select random student
     * - Check if they graduated 
     * - If not, student studies
     */
    private void nextStep() {
        if (students.isEmpty()) {
            System.out.println("Everything has gone quiet.");
        } else {
            int randomIndex = random.nextInt(students.size());
            Student selectedStudent = students.get(randomIndex);

            if (selectedStudent.finishedStudies()) {
                students.remove(selectedStudent);
                System.out.println("The student has graduated and left the college.");
            } else {
                selectedStudent.study();
            }
        }
    }

    /**
     * Runs the simulation for given number of steps  
     * @param nSteps Number of steps   
     */
    public void runCollege(int nSteps) {
        for (int step = 1; step <= nSteps; step++) {
            System.out.println("Step " + step);
            describe();
            nextStep();
        }
    }

    /**
     * Main method to run the college simulation 
     * @param args Command line params
     */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java College <numStudents> <numTextBooks> <numSteps>");
            System.exit(1); 
        }

        int numStudents = Integer.parseInt(args[0]);
        int numTextBooks = Integer.parseInt(args[1]);  
        int numSteps = Integer.parseInt(args[2]);

        College college = new College(numStudents, numTextBooks);
        college.runCollege(numSteps);
    }  
}