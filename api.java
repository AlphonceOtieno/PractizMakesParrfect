import java.util.*;

// Simple Student Model
class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

// Simple Student API - Simulates REST endpoints
class StudentAPI {
    private List<Student> students = new ArrayList<>();

    public StudentAPI() {
        // Initialize with sample data
        students.add(new Student(1, "Alice", 3.8));
        students.add(new Student(2, "Bob", 3.5));
        students.add(new Student(3, "Charlie", 3.9));
    }

    // GET: Retrieve all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    // GET: Retrieve a specific student by ID
    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
 
    // POST: Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("✓ Student added: " + student);
    }

    // PUT: Update student GPA
    public boolean updateStudentGpa(int id, double newGpa) {
        for (Student s : students) {
            if (s.getId() == id) {
                // In a real API, this would update the database
                System.out.println("✓ Updated student " + s.getName() + "'s GPA to " + newGpa);
                return true;
            }
        }
        return false;
    }

    // DELETE: Remove a student
    public boolean deleteStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);
        if (removed) {
            System.out.println("✓ Student with ID " + id + " deleted");
        }
        return removed;
    }
}

// Main class to demonstrate API usage
public class api {
    public static void main(String[] args) {
        System.out.println("=== STUDENT MANAGEMENT API DEMO ===\n");

        StudentAPI api = new StudentAPI();

        // 1. GET - Retrieve all students
        System.out.println("1. GET /students - Retrieve all students:");
        api.getAllStudents().forEach(System.out::println);

        // 2. GET - Retrieve specific student
        System.out.println("\n2. GET /students/2 - Retrieve student with ID 2:");
        System.out.println(api.getStudentById(2));

        // 3. POST - Add new student
        System.out.println("\n3. POST /students - Add new student:");
        api.addStudent(new Student(4, "Diana", 3.7));

        // 4. PUT - Update student
        System.out.println("\n4. PUT /students/1 - Update student 1's GPA:");
        api.updateStudentGpa(1, 3.95);

        // 5. DELETE - Remove student
        System.out.println("\n5. DELETE /students/3 - Delete student with ID 3:");
        api.deleteStudent(3);

        // Final state
        System.out.println("\n6. Final List of all students:");
        api.getAllStudents().forEach(System.out::println);
    }
}
