import java.util.ArrayList;
import java.util.Random;
// The College class simulates a college with a library and students.
public class College {
    private ArrayList<Student> students;
    private Library library;
    private Random random;

    // Constructor to initialize a new College object.
    // @param numStudents The number of students enrolled at the college.
    // @param numBooks The number of textbooks in the library.
    public College(int numStudents, int numBooks) {
        this.students = new ArrayList<>();
        this.library = new Library(numBooks);
        this.random = new Random();

        for (int i = 1; i <= numStudents; i++) {
            students.add(new Student("Student" + i, library));
        }
    }

    // Prints out a simple description of the state of the College.
    public void describe() {
        System.out.println("The college currently has " + students.size() + " hard-working students");
        library.describe();
    }

    // Internal method for the next step in the college simulation.
    // - Selects a random student.
    // - Removes the student if they have finished studies.
    // - Otherwise, the student studies.
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

    // Runs the college simulation for a specified number of steps.
    // @param nSteps The number of steps to run.
    public void runCollege(int nSteps) {
        for (int step = 1; step <= nSteps; step++) {
            System.out.println("Step " + step);
            describe();
            nextStep();
        }
    }

    // Main method to run the college simulation.
    // @param args Command line parameters for the number of students, number of textbooks, and number of steps.
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