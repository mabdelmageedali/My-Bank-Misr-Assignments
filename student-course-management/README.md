# Student Course Management System

A Spring Boot application that manages students, courses, and categories with proper JPA relationships and DTOs to avoid recursion issues.

## Project Overview

This project demonstrates a well-structured Spring Boot application with:
- JPA entities with proper relationships
- Repository pattern for data access
- DTOs to prevent JSON serialization recursion
- Clean code structure and naming conventions
- Sample data initialization

## Features

### Entities
- **Student**: Manages student information (id, name, email, age)
- **Course**: Manages course details (id, name, description)
- **Category**: Manages course categories (id, name)

### Relationships
- **Student ↔ Course**: Many-to-Many relationship
- **Course → Category**: Many-to-One relationship

### Recursion Prevention
- Used `@JsonIgnore` annotations on bidirectional relationships
- Created DTOs that break circular references
- DTOs include computed fields like counts and related entity names


```

## Technology Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **H2 Database** (in-memory for development)
- **Maven** (build tool)

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. **Clone or download the project**

2. **Navigate to the project directory**
   ```bash
   cd student-course-management
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - Application runs on: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`
     - JDBC URL: `jdbc:h2:mem:testdb`
     - Username: `sa`
     - Password: `password`

## Database Schema

The application automatically creates the following tables:
- `students` - Student information
- `courses` - Course details
- `categories` - Course categories
- `student_courses` - Join table for many-to-many relationship


## Key Features

### JPA Annotations Used
- `@Entity` - Marks classes as JPA entities
- `@Table` - Specifies table names
- `@Id` - Marks primary key fields
- `@GeneratedValue` - Auto-generates primary key values
- `@Column` - Configures column properties
- `@ManyToOne` - Defines many-to-one relationships
- `@OneToMany` - Defines one-to-many relationships
- `@ManyToMany` - Defines many-to-many relationships
- `@JoinTable` - Configures join tables
- `@JoinColumn` - Configures join columns

### Repository Features
Each repository extends `JpaRepository` and includes custom query methods:
- Find by various criteria
- Custom JPQL queries
- Existence checks
- Count operations

### DTO Benefits
- **StudentDto**: Includes course names and count without circular references
- **CourseDto**: Includes category information and student count
- **CategoryDto**: Includes course count
- Prevents infinite recursion in JSON serialization
- Provides clean API responses

## API Endpoints (Future Enhancement)

The project structure supports easy addition of REST controllers for:
- `/api/students` - Student management
- `/api/courses` - Course management
- `/api/categories` - Category management

## Development Notes

### Avoiding Recursion
1. **@JsonIgnore**: Used on collection fields in entities
2. **DTOs**: Created separate data transfer objects
3. **Lazy Loading**: Used `FetchType.LAZY` for performance

### Best Practices Implemented
- Clean package structure
- Meaningful naming conventions
- Proper relationship mappings
- Helper methods for relationship management
- Comprehensive toString methods
- Constructor overloading

## Testing

The project includes:
- H2 in-memory database for testing
- Sample data for verification
- Repository interfaces ready for unit testing

## Future Enhancements

- REST API controllers
- Service layer implementation
- Input validation
- Exception handling
- Pagination support
- Search functionality
- Unit and integration tests

## License

This project is created for educational purposes.

