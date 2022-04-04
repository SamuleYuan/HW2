package com.example.hw2.controller;

import com.example.hw2.domain.Teacher;
import com.example.hw2.exception.NotFoundException;
import com.example.hw2.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  What is MVC ?
 *
 *  database < - > server
 *                 Repository layer +  Service layer + Controller Layer
 */
@RestController
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
    }
    @GetMapping("/teacher/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable String id) {
        return new ResponseEntity<>(teacherService.getTeacherById(id), HttpStatus.OK);
    }
    @PostMapping("/teacher")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeacher(@PathVariable String id, @PathVariable String name, @PathVariable List<String> listStudentId){
        teacherService.updateTeacher(id, name, listStudentId);
    }
    @PutMapping("/teacher")
    public void updateTeacher(@PathVariable String id, @PathVariable String name, @PathVariable List<String> listStudentId){
        teacherService.updateTeacher(id, name, listStudentId);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> customizedExceptionHandler() {
        return new ResponseEntity<>("teacher not found", HttpStatus.NOT_FOUND);
    }
}
