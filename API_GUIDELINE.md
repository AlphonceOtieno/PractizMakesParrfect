# Student Management API Guideline

This file explains the structure and purpose of the simple `api.java` example. It describes how the API works, what it connects, and how to extend it.

## 1. Overview

The `api.java` example simulates a small REST-style API for managing student records. It is not a real HTTP server, but it models the same logical operations that a REST API provides.

## 2. Components

### 2.1 Student Model

- `Student` is a plain Java class.
- It has three fields:
  - `id` (int)
  - `name` (String)
  - `gpa` (double)
- It includes constructors, getters, and a `toString()` method for display.

### 2.2 StudentAPI

- `StudentAPI` acts like an API service layer.
- It stores students in memory using `List<Student>`.
- It simulates API endpoints with methods:
  - `getAllStudents()` - returns all students
  - `getStudentById(int id)` - returns a student by its ID
  - `addStudent(Student student)` - adds a new student
  - `updateStudentGpa(int id, double newGpa)` - updates a student's GPA
  - `deleteStudent(int id)` - deletes a student by ID

### 2.3 Main Class

- The `api` class contains the `main` method.
- It calls the `StudentAPI` methods in sequence.
- It prints output to show how each operation works.

## 3. What the API connects

This example shows a connection between:

- **Client code**: the `main` method that requests operations
- **Service layer**: the `StudentAPI` object that performs actions
- **Data storage**: the in-memory `List<Student>` that stores student records

In a real web API, these would map to:

- **HTTP client or frontend** making requests
- **Server endpoint handlers** processing requests
- **Database** storing data persistently

## 4. Simulated REST operations

The example uses method names that correspond to common REST actions:

1. `GET /students` → `getAllStudents()`
2. `GET /students/{id}` → `getStudentById(id)`
3. `POST /students` → `addStudent(student)`
4. `PUT /students/{id}` → `updateStudentGpa(id, newGpa)`
5. `DELETE /students/{id}` → `deleteStudent(id)`

## 5. How to use it

1. Open `api.java` in your editor.
2. Run it as a Java application.
3. Observe the printed output for each operation.
4. Modify the sample data or add new operations to experiment.

## 6. How to extend the example

### Add a new field

- Add a field like `major` or `email` to `Student`.
- Update the constructor, getters, and `toString()`.
- Use the new field in the output and API operations.

### Add a real data store

- Replace `ArrayList<Student>` with a database connection.
- In a real API, `StudentAPI` would query and update the database instead of working with an in-memory list.

### Turn it into a real web API

- Use a Java web framework such as Spring Boot, Spark Java, or Javalin.
- Create HTTP routes for each operation.
- Convert method calls into HTTP request handlers.

## 7. Why this is useful

- Teaches the basic structure of an API.
- Demonstrates CRUD operations clearly.
- Provides a simple foundation for building a real service later.

## 8. Notes

- This example is intentionally simple.
- It is best used for learning and prototyping.
- It does not include persistence, authentication, or error handling.
