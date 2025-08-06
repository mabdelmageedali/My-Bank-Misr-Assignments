package com.example.studentcourse.dto;

import com.example.studentcourse.entity.Course;

public class CourseDto {
    
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private String categoryName;
    private Integer studentCount;
    

    public CourseDto() {}
    

    public CourseDto(Long id, String name, String description, Long categoryId, String categoryName, Integer studentCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.studentCount = studentCount;
    }
    

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.description = course.getDescription();
        if (course.getCategory() != null) {
            this.categoryId = course.getCategory().getId();
            this.categoryName = course.getCategory().getName();
        }
        this.studentCount = course.getStudents() != null ? course.getStudents().size() : 0;
    }
    

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Long getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public Integer getStudentCount() {
        return studentCount;
    }
    
    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }
    
    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", studentCount=" + studentCount +
                '}';
    }
}

