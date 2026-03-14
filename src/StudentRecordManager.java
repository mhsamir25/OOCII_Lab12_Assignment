import java.util.*;
import java.util.stream.Collectors;

/*
 * StudentRecordManager Class - Manages student records with advanced operations
 * 
 * This class provides high-level operations for managing student records including:
 * - Sorting students by GPA
 * - Searching for specific students
 * - Grouping students by gender
 * 
 * It leverages Java Collections Framework and Streams API for efficient operations.
 * 
 */

public class StudentRecordManager {
    
    // DataStore to hold Student objects using generics
    private DataStore<Student> studentStore;
    
    /*
     * Constructor - Initializes the StudentRecordManager with an empty DataStore
     */
    public StudentRecordManager() {
        this.studentStore = new DataStore<>();
    }
    
    // -----------BASIC STUDENT MANAGEMENT ---------------
    
    /**
     * Adds a new student to the record manager
     * 
     * @param student The Student object to add
     * @return true if addition was successful
     */
    public boolean addStudent(Student student) {
        if (student == null) {
            System.out.println("Error: Cannot add null student");
            return false;
        }
        return studentStore.add(student);
    }
    
    /**
     * Removes a student from the record manager
     * 
     * @param student The Student object to remove
     * @return true if removal was successful
     */
    public boolean removeStudent(Student student) {
        return studentStore.remove(student);
    }
    
    /**
     * Returns the total number of students in the system
     * 
     * @return Count of all students
     */
    public int getTotalStudents() {
        return studentStore.size();
    }
    
    /**
     * Retrieves all students
     * 
     * @return List containing all Student objects
     */
    public List<Student> getAllStudents() {
        return studentStore.getAll();
    }
    
    // ------------ SORTING OPERATIONS -------------
    
    /**
     * Sorts students by GPA in descending order (highest GPA first)
     * 
     * This method:
     * 1. Creates a copy of all students to avoid modifying original order
     * 2. Uses Collections.sort() which calls Student's compareTo() method
     * 3. Returns a new sorted list without modifying the original store
     * 
     * @return A new List of Students sorted by GPA (descending)
     */
    public List<Student> sortByGPA() {
        // Create a copy of all students
        List<Student> sortedList = new ArrayList<>(studentStore.getAll());
        
        // Sort using the compareTo method from Student class
        // Student.compareTo() sorts in descending order (highest GPA first)
        Collections.sort(sortedList);
        
        return sortedList;
    }
    
    // -------------- SEARCH OPERATIONS -----------------
    
    /**
     * Searches for a student by Student ID
     * 
     * This method:
     * 1. Iterates through all students in the store
     * 2. Compares student IDs with the search criteria
     * 3. Returns the matching Student or null if not found
     * 
     * Time Complexity: O(n) where n is the number of students
     * 
     * @param studentID The ID to search for
     * @return The Student object if found, null otherwise
     */
    public Student searchByID(String studentID) {
        for (Student student : studentStore.getAll()) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }
    
    /**
     * Searches for students by name (partial or complete match)
     * 
     * This method:
     * 1. Uses Java Streams API for functional filtering
     * 2. Performs case-insensitive partial name matching
     * 3. Returns all matching students
     * 
     * @param name The name or partial name to search for
     * @return A List of Students matching the search criteria
     */
    public List<Student> searchByName(String name) {
        return studentStore.getAll().stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    /**
     * Searches for students by GPA threshold
     * 
     * @param minGPA The minimum GPA threshold
     * @return A List of Students with GPA greater than or equal to minGPA
     */
    public List<Student> searchByGPA(double minGPA) {
        return studentStore.getAll().stream()
                .filter(s -> s.getGPA() >= minGPA)
                .collect(Collectors.toList());
    }
    
    // ------------- GROUPING OPERATIONS ----------------
    
    /**
     * Groups students by gender into separate lists
     * 
     * This method demonstrates:
     * 1. Java Streams API and Collectors.groupingBy()
     * 2. Generic type parameters for flexible grouping
     * 3. Map data structure for key-value pairing (Gender -> List of Students)
     * 
     * The returned Map will contain:
     * - Key: Gender string (e.g., "M" for Male, "F" for Female)
     * - Value: List of all Students with that gender
     * 
     * Time Complexity: O(n) where n is the number of students
     * 
     * @return A Map with Gender as key and List<Student> as value
     */
    public Map<String, List<Student>> groupByGender() {
        // Use Streams API to group students by gender
        // This creates a Map where:
        // - Key = Gender string
        // - Value = List of all students with that gender
        return studentStore.getAll().stream()
                .collect(Collectors.groupingBy(
                        Student::getGender,  // Grouping key: gender
                        Collectors.toList()  // Collection type: List
                ));
    }
    
    // ------------- UTILITY METHODS ------------------
    
    /**
     * Displays all students in a formatted table
     */
    public void displayAllStudents() {
        if (studentStore.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        
        System.out.println("\n------------ ALL STUDENTS -------------");
        System.out.println(String.format("%-6s | %-20s | %-6s | %s",
                "ID", "Name", "GPA", "Gender"));
        System.out.println("=".repeat(50));
        
        for (Student student : studentStore.getAll()) {
            System.out.println(student);
        }
        System.out.println("=".repeat(50) + "\n");
    }
    
    /**
     * Displays students sorted by GPA
     */
    public void displaySortedByGPA() {
        List<Student> sorted = sortByGPA();
        
        if (sorted.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        
        System.out.println("\n------------- STUDENTS SORTED BY GPA (HIGHEST FIRST) ------------");
        System.out.println(String.format("%-6s | %-20s | %-6s | %s",
                "ID", "Name", "GPA", "Gender"));
        System.out.println("=".repeat(55));
        
        for (Student student : sorted) {
            System.out.println(student);
        }
        System.out.println("=".repeat(55) + "\n");
    }
    
    /**
     * Displays students grouped by gender
     */
    public void displayGroupedByGender() {
        Map<String, List<Student>> groupedStudents = groupByGender();
        
        if (groupedStudents.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        
        System.out.println("\n========== STUDENTS GROUPED BY GENDER ==========");
        
        for (String gender : groupedStudents.keySet()) {
            List<Student> students = groupedStudents.get(gender);
            String genderLabel = gender.equals("M") ? "Male" : "Female";
            
            System.out.println("\n" + genderLabel + " Students (" + students.size() + "):");
            System.out.println(String.format("%-6s | %-20s | %s",
                    "ID", "Name", "GPA"));
            System.out.println("-".repeat(40));
            
            for (Student student : students) {
                System.out.printf("%-6s | %-20s | %.2f%n",
                        student.getStudentID(),
                        student.getName(),
                        student.getGPA());
            }
        }
        System.out.println("\n" + "=".repeat(45) + "\n");
    }
}
