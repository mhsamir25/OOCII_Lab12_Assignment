/**
 * Student Class - Represents a student entity with essential academic details
 * This class encapsulates student information including ID, Name, GPA, and Gender.
 * It implements Comparable<Student> interface to enable sorting by GPA.
 */

public class Student implements Comparable<Student> {
    
    // Private attributes to maintain encapsulation
    private String studentID;
    private String name;
    private double gpa;
    private String gender;
    
    /**
     * Constructor to initialize a Student object with all attributes
     * 
     * @param studentID The unique identifier for the student
     * @param name The full name of the student
     * @param gpa The grade point average (0.0 - 4.0)
     * @param gender The gender of the student ("M" or "F")
     */
    public Student(String studentID, String name, double gpa, String gender) {
        this.studentID = studentID;
        this.name = name;
        this.gpa = gpa;
        this.gender = gender;
    }
    
    // ----------- GETTER METHODS --------------
    
    public String getStudentID() {
        return studentID;
    }
    
    public String getName() {
        return name;
    }
    
    public double getGPA() {
        return gpa;
    }
    
    public String getGender() {
        return gender;
    }
    
    // -------------- COMPARABLE IMPLEMENTATION ---------------
    
    /**
     * Compares this student with another student by GPA (descending order)
     * This enables sorting students from highest to lowest GPA
     * 
     * @param other The other Student object to compare with
     * @return negative if this GPA is higher, positive if lower, 0 if equal
     */
    @Override
    public int compareTo(Student other) {
        // Compare in descending order (highest GPA first)
        return Double.compare(other.gpa, this.gpa);
    }
    
    // -------------- OBJECT METHODS ----------------
    
    /**
     * Returns a string representation of the Student object
     * 
     * @return Formatted string with all student details
     */
    @Override
    public String toString() {
        return String.format("ID: %-6s | Name: %-20s | GPA: %.2f | Gender: %s",
                studentID, name, gpa, gender);
    }
    
    /**
     * Checks equality of two Student objects based on StudentID
     * 
     * @param obj The object to compare
     * @return true if student IDs match, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Student student = (Student) obj;
        return this.studentID.equals(student.studentID);
    }
}
