package com.example.studentcourse.controller;

import com.example.studentcourse.dto.StudentDto;
import com.example.studentcourse.entity.Student;
import com.example.studentcourse.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(student -> ResponseEntity.ok(new StudentDto(student)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<StudentDto> getStudentByEmail(@PathVariable String email) {
        return studentRepository.findByEmail(email)
                .map(student -> ResponseEntity.ok(new StudentDto(student)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StudentDto createStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return new StudentDto(savedStudent);
    }
}

