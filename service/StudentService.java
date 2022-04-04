package com.example.hw2.service;

import com.example.hw2.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    Student getStudentById(String id);
    List<Student> getAllStudents();
    void updateStudent(String id, String name, List<String> listTeacherId);
}
