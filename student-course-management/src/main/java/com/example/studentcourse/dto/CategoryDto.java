package com.example.studentcourse.dto;

import com.example.studentcourse.entity.Category;

public class CategoryDto {
    
    private Long id;
    private String name;
    private Integer courseCount;
    

    public CategoryDto() {}
    

    public CategoryDto(Long id, String name, Integer courseCount) {
        this.id = id;
        this.name = name;
        this.courseCount = courseCount;
    }
    

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.courseCount = category.getCourses() != null ? category.getCourses().size() : 0;
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
    
    public Integer getCourseCount() {
        return courseCount;
    }
    
    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }
    
    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseCount=" + courseCount +
                '}';
    }
}

