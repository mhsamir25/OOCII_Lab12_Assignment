import java.util.*;

/**
 * App Class - Main Application Entry Point
 * 
 * This class demonstrates the Student Record Management System with all
 * required functionalities:
 * 1. Generic DataStore<T> for type-safe object storage
 * 2. Sorting students by GPA (descending order)
 * 3. Searching for students by various criteria
 * 4. Grouping students by gender
 * 
 * The application creates sample student records and performs various
 * operations to showcase the system capabilities.
 */

public class App {
    
    public static void main(String[] args) throws Exception {
        // Initialize the Student Record Manager
        StudentRecordManager manager = new StudentRecordManager();
        
        System.out.println("+------------------------------------------------------------+");
        System.out.println("|             STUDENT RECORD MANAGEMENT SYSTEM               |");
        System.out.println("+------------------------------------------------------------+");
        
        // ============ TASK 1: POPULATE DATABASE WITH SAMPLE STUDENTS ============
        System.out.println("\n[STEP 1] Loading Student Records into the System...\n");
        
        // Create sample student records
        Student[] students = {
            new Student("S001", "Mahmudul Hossain Samir", 3.85, "M"),
            new Student("S002", "Ashfaq Sadad", 3.45, "M"),
            new Student("S003", "Fatima Ahmed", 3.92, "F"),
            new Student("S004", "Muntajim Rahman Saimon", 3.65, "M"),
            new Student("S005", "Suraiya Zaman", 3.78, "F"),
            new Student("S006", "Omar Abdullah", 3.55, "M"),
            new Student("S007", "Afsia Tafsin", 3.88, "F"),
            new Student("S008", "Tahsinuzzaman Emon", 3.42, "M"),
            new Student("S009", "Umama Fairuz Khan", 3.75, "F"),
            new Student("S010", "Safwan Hasan Khan", 3.98, "M")
        };
        
        // Add all students to the manager
        for (Student student : students) {
            manager.addStudent(student);
            System.out.println("Added: " + student.getName());
        }
        
        System.out.println("\n Successfully loaded " + manager.getTotalStudents() + " students into the system.\n");
        
        // ============ DISPLAY ALL STUDENTS ============
        manager.displayAllStudents();
        
        // ============ TASK 2: SORT BY GPA ============
        System.out.println("\n[STEP 2] Demonstrating GPA-Based Sorting...\n");
        System.out.println("The sorted list demonstrates the usage of the Comparable interface");
        System.out.println("and Java's Collections.sort() method.\n");
        
        manager.displaySortedByGPA();
        
        // ============ TASK 3: SEARCH OPERATIONS ============
        System.out.println("[STEP 3] Demonstrating Search Functionalities...\n");
        
        // Search by ID
        System.out.println("--- Search by Student ID ---");
        String searchID = "S005";
        Student found = manager.searchByID(searchID);
        if (found != null) {
            System.out.println("✓ Found student with ID " + searchID + ":");
            System.out.println("  " + found);
        } else {
            System.out.println("✗ Student with ID " + searchID + " not found.");
        }
        
        // Search by Name (partial match)
        System.out.println("\n--- Search by Name (Partial Match) ---");
        String searchName = "Ali";
        System.out.println("Searching for students containing name: \"" + searchName + "\"");
        System.out.println(String.format("%-6s | %-20s | %-6s | %s",
                "ID", "Name", "GPA", "Gender"));
        System.out.println("-".repeat(45));
        
        List<Student> nameResults = manager.searchByName(searchName);
        if (!nameResults.isEmpty()) {
            for (Student student : nameResults) {
                System.out.println(student);
            }
            System.out.println(" Found " + nameResults.size() + " matching student(s).\n");
        } else {
            System.out.println(" No students found with that name.\n");
        }
        
        // Search by GPA threshold
        System.out.println("--- Search by GPA Threshold ---");
        double minGPA = 3.80;
        System.out.println("Searching for students with GPA >= " + minGPA);
        System.out.println(String.format("%-6s | %-20s | %-6s | %s",
                "ID", "Name", "GPA", "Gender"));
        System.out.println("-".repeat(45));
        
        List<Student> gpaResults = manager.searchByGPA(minGPA);
        if (!gpaResults.isEmpty()) {
            for (Student student : gpaResults) {
                System.out.println(student);
            }
            System.out.println("✓ Found " + gpaResults.size() + " student(s) meeting the criteria.\n");
        } else {
            System.out.println("✗ No students found meeting the criteria.\n");
        }
        
        // ============ TASK 4: GROUP BY GENDER ============
        System.out.println("[STEP 4] Demonstrating Gender-Based Grouping...\n");
        System.out.println("The grouping demonstrates usage of:");
        System.out.println("- Java Streams API (functional programming)");
        System.out.println("- Collectors.groupingBy() for data aggregation");
        System.out.println("- Map<K,V> for key-value pair storage\n");
        
        manager.displayGroupedByGender();
        
        // ============ FINAL STATISTICS ============
        System.out.println("[SUMMARY] System Statistics");
        System.out.println("================================");
        System.out.println("Total Students: " + manager.getTotalStudents());
        
        Map<String, List<Student>> grouped = manager.groupByGender();
        for (String gender : grouped.keySet()) {
            String genderLabel = gender.equals("M") ? "Male" : "Female";
            System.out.println(genderLabel + " Students: " + grouped.get(gender).size());
        }
        
        List<Student> topStudents = manager.searchByGPA(3.90);
        System.out.println("Students with GPA >= 3.90: " + topStudents.size());

        System.out.println("\n");
        System.out.println("Application Execution Complete");
    }
}
