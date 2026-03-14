# Student Record Management System
## OOC II Lab Assignment - Lab 12

**Assignment:** Lab 12 - SWE 4302-OOC II Lab
**Student ID:** 230042101
**Date:** March 14, 2026

---

## SUMMARY

This document presents a comprehensive implementation of a **Student Record Management System** developed as an assignment for the Object-Oriented Concepts II (OOC II) course. The system demonstrates advanced Java programming concepts including **Java Generics**, **Collections Framework**, **Object-Oriented Design Principles**, and **Functional Programming with Streams API**.

The system provides a complete solution for storing, managing, and analyzing student records in an academic institution with a focus on code reusability, type safety, and maintainability.

---

## 1. INTRODUCTION

### 1.1 Problem Statement
Universities require a flexible, maintainable system to manage student records. The challenge lies in creating a solution that:
- Can store diverse types of data objects (Generic Programming)
- Provides efficient sorting and searching capabilities
- Groups data based on specific criteria
- Maintains type safety at compile time
- Adheres to SOLID principles and Java best practices

### 1.2 Solution Overview
This project implements a Student Record Management System that addresses all requirements through:
1. A **Generic DataStore<T>** class for flexible object storage
2. **GPA-based sorting** using Comparable interface
3. **Multiple search strategies** using linear search and Streams API
4. **Gender-based grouping** using Collectors.groupingBy()

---

## 2. SYSTEM ARCHITECTURE

### 2.1 Class Hierarchy

```
Student Record Management System
├── App.java (Main Entry Point)
├── Student.java (Entity Class)
├── DataStore<T>.java (Generic Container)
└── StudentRecordManager.java (Manager Class)
```

### 2.2 Design Patterns Used

| Pattern | Implementation | Purpose |
|---------|----------------|---------|
| Generic Programming | DataStore<T> class | Type-safe, reusable container |
| Collections Framework | ArrayList, List, Map | Efficient data management |
| Comparable Interface | Student implements Comparable<Student> | Enabling sorting |
| Streams API | Functional filtering and mapping | Efficient data querying |
| Encapsulation | Private attributes with public getters | Data protection |
| Single Responsibility | Each class has one purpose | Maintainability |

---

## 3. DETAILED IMPLEMENTATION

### 3.1 TASK 1: Generic DataStore<T> Class

**File:** `DataStore.java`

This class is a generic, reusable container that demonstrates type safety and flexibility. It can store and manage objects of any type.

**Key Methods:**
- `add(T item)` - Add an object to the store
- `remove(T item)` - Remove an object from the store
- `get(int index)` - Retrieve object at specific index
- `getAll()` - Get all objects as a List
- `contains(T item)` - Check if object exists
- `size()` - Get total number of items

**Benefits of Generics:**
- Type safety at compile time
- No need for type casting
- Reusable across different data types
- Better code readability

---

### 3.2 TASK 2: GPA-Based Sorting

**Implementation Location:** `StudentRecordManager.sortByGPA()`

The system sorts students in descending order (highest GPA first) using:
1. **Comparable Interface** - Student class implements `Comparable<Student>`
2. **compareTo() Method** - Returns comparison based on GPA (descending)
3. **Collections.sort()** - O(n log n) Timsort algorithm

**Key Code:**
```java
@Override
public int compareTo(Student other) {
    return Double.compare(other.gpa, this.gpa);  // Descending order
}
```

**Complexity:**
- Time: O(n log n)
- Space: O(n) for creating copy

---

### 3.3 TASK 3: Search Operations

The system provides three search strategies:

#### 3.3.1 Search by Student ID
- Exact match search
- Returns single Student or null
- Time Complexity: O(n)
- Use Case: Retrieve specific student record

#### 3.3.2 Search by Name
- Partial, case-insensitive matching
- Uses Streams API filter
- Returns List of matching students
- Time Complexity: O(n)
- Use Case: Find students by name pattern

#### 3.3.3 Search by GPA Threshold
- Threshold-based filtering
- Uses Streams API filter
- Returns List of students meeting criteria
- Time Complexity: O(n)
- Use Case: Find honor students

---

### 3.4 TASK 4: Gender-Based Grouping

**Implementation Location:** `StudentRecordManager.groupByGender()`

Groups students by gender using Java Streams API and Collectors.

**Key Code:**
```java
public Map<String, List<Student>> groupByGender() {
    return studentStore.getAll().stream()
            .collect(Collectors.groupingBy(
                    Student::getGender,
                    Collectors.toList()
            ));
}
```

**Result Structure:**
```
Map: {
    "M" => [List of male students],
    "F" => [List of female students]
}
```

**Complexity:**
- Time: O(n) - single pass through students
- Space: O(n) - stores all students in new structure

---

## 4. JAVA COLLECTIONS FRAMEWORK

### Collections Used

| Collection | Purpose | Why Selected |
|-----------|---------|--------------|
| ArrayList<T> | Internal storage in DataStore | Dynamic sizing, O(1) access |
| List<Student> | Query return type | Ordered collection |
| Map<String, List<Student>> | Grouping result | Key-value association |
| Iterator<T> | Traversing DataStore | Safe iteration |

### Stream API Operations

| Operation | Purpose |
|-----------|---------|
| `.stream()` | Convert collection to stream |
| `.filter()` | Select elements by condition |
| `.collect()` | Gather results |
| `.groupingBy()` | Group elements by classifier |

---

## 6. CODING PERSPECTIVE FEATURES

### 6.1 Encapsulation
- Private attributes in all classes
- Public getter methods for controlled access
- Protected internal implementations

### 6.2 Documentation
- Comprehensive Javadoc comments
- Inline comments explaining logic
- Class-level documentation

### 6.3 Error Handling
- Null checks before operations
- Graceful handling of empty collections
- Meaningful error messages

### 6.4 Code Style
- Consistent naming conventions
- Meaningful variable names
- Logical method organization
- Proper indentation (4 spaces)

---

## 7. COMPILATION AND EXECUTION

### 7.1 Compile

```bash
cd /path/to/230042101_OOCII_Lab12
javac src/*.java -d bin/
```

### 7.2 Run

```bash
java -cp bin/ App
```

### 7.3 Expected Output

The program demonstrates:
1. Loading 10 students into the system
2. Displaying all students
3. Sorting by GPA (highest first)
4. Searching by ID, Name, and GPA threshold
5. Grouping students by gender
6. System statistics

---

## 8. LEARNING OUTCOMES DEMONSTRATED

### Object-Oriented Concepts
- ✓ Encapsulation
- ✓ Inheritance (Comparable<Student>)
- ✓ Polymorphism (compareTo() overriding)
- ✓ Abstraction

### Generic Programming
- ✓ Type Parameters (DataStore<T>)
- ✓ Type Safety
- ✓ Code Reusability

### Collections Framework
- ✓ List and Map interfaces
- ✓ Sorting mechanisms
- ✓ Iteration patterns
- ✓ Collection utilities

### Functional Programming
- ✓ Streams API
- ✓ Lambda expressions
- ✓ Method references
- ✓ Collectors

### Best Practices
- ✓ SOLID Principles
- ✓ Code documentation
- ✓ Error handling
- ✓ Clean code standards

---

## 9. POTENTIAL EXTENSIONS

The system can be extended with:

```java
// Statistics
public double getAverageGPA()
public List<Student> getTopStudents(int n)

// Advanced filtering
public List<Student> filterByMajor(String major)
public List<Student> filterByGPARange(double min, double max)

// Persistence
public void saveToFile(String filename)
public void loadFromFile(String filename)

// Database integration
public void saveToDatabase()
public List<Student> loadFromDatabase()
```

---

## 10. CONCLUSION

This Student Record Management System successfully demonstrates all four required tasks:

1. **Generic DataStore<T>** - Type-safe, reusable container for any data type
2. **GPA Sorting** - Using Comparable interface and Collections.sort()
3. **Search Operations** - Multiple strategies for flexible data retrieval
4. **Gender Grouping** - Using Streams API and Collectors.groupingBy()



---

