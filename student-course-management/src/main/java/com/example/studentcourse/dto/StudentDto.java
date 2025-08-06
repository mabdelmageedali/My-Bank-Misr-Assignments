package com.example.studentcourse.dto;

import com.example.studentcourse.entity.Student;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDto {
    
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private Integer courseCount;
    private List<String> courseNames;
    
    // Default constructor
    public StudentDto() {}
    
    // Constructor with basic fields
    public StudentDto(Long id, String name, String email, Integer age, Integer courseCount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.courseCount = courseCount;
    }
    
    // Constructor from entity
    public StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.age = student.getAge();
        this.courseCount = student.getCourses() != null ? student.getCourses().size() : 0;
        if (student.getCourses() != null) {
            this.courseNames = student.getCourses().stream()
                    .map(course -> course.getName())
                    .collect(Collectors.toList());
        }
    }
    
    // Getters and Setters
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Integer getCourseCount() {
        return courseCount;
    }
    
    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }
    
    public List<String> getCourseNames() {
        return courseNames;
    }
    
    public void setCourseNames(List<String> courseNames) {
        this.courseNames = courseNames;
    }
    
    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", courseCount=" + courseCount +
                ", courseNames=" + courseNames +
                '}';
    }
}

