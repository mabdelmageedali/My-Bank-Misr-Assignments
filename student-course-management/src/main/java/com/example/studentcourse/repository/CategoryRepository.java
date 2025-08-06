package com.example.studentcourse.repository;

import com.example.studentcourse.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    // Find category by name
    Optional<Category> findByName(String name);
    
    // Find categories by name containing (case insensitive)
    List<Category> findByNameContainingIgnoreCase(String name);
    
    // Find categories that have courses
    @Query("SELECT DISTINCT c FROM Category c WHERE SIZE(c.courses) > 0")
    List<Category> findCategoriesWithCourses();
    
    // Find categories with course count
    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.courses")
    List<Category> findAllWithCourses();
    
    // Check if category name exists
    boolean existsByName(String name);
    
    // Count courses in category
    @Query("SELECT COUNT(co) FROM Course co WHERE co.category.id = :categoryId")
    Long countCoursesInCategory(@Param("categoryId") Long categoryId);
}

