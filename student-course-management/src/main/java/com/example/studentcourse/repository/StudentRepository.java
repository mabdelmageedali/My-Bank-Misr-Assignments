package com.example.studentcourse.repository;

import com.example.studentcourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // Find student by email
    Optional<Student> findByEmail(String email);
    
    // Find students by name containing (case insensitive)
    List<Student> findByNameContainingIgnoreCase(String name);
    
    // Find students by age range
    List<Student> findByAgeBetween(Integer minAge, Integer maxAge);
    
    // Find students enrolled in a specific course
    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.id = :courseId")
    List<Student> findStudentsByCourseId(@Param("courseId") Long courseId);
    
    // Check if email exists
    boolean existsByEmail(String email);
}

