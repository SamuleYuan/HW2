package com.example.hw2.controller;

import com.example.hw2.domain.Student;
import com.example.hw2.exception.NotFoundException;
import com.example.hw2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/student/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@PathVariable String id, @PathVariable String name, @PathVariable List<String> listTeacherId){
        studentService.updateStudent(id, name, listTeacherId);
    }
    @PutMapping("/student")
    public void updateStudent(@PathVariable String id, @PathVariable String name, @PathVariable List<String> listTeacherId){
        studentService.updateStudent(id, name, listTeacherId);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> customizedExceptionHandler() {
        return new ResponseEntity<>("student not found", HttpStatus.NOT_FOUND);
    }
}
