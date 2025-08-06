package com.example.studentcourse.repository;

import com.example.studentcourse.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
    // Find courses by name containing (case insensitive)
    List<Course> findByNameContainingIgnoreCase(String name);
    
    // Find courses by category id
    List<Course> findByCategoryId(Long categoryId);
    
    // Find courses by category name
    @Query("SELECT c FROM Course c WHERE c.category.name = :categoryName")
    List<Course> findByCategoryName(@Param("categoryName") String categoryName);
    
    // Find courses that have students enrolled
    @Query("SELECT DISTINCT c FROM Course c WHERE SIZE(c.students) > 0")
    List<Course> findCoursesWithStudents();
    
    // Find courses by student id
    @Query("SELECT c FROM Course c JOIN c.students s WHERE s.id = :studentId")
    List<Course> findCoursesByStudentId(@Param("studentId") Long studentId);
    
    // Count courses by category
    @Query("SELECT COUNT(c) FROM Course c WHERE c.category.id = :categoryId")
    Long countCoursesByCategory(@Param("categoryId") Long categoryId);
}

