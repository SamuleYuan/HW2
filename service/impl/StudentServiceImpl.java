package com.example.hw2.service.impl;

import com.example.hw2.domain.Student;
import com.example.hw2.repository.StudentRepo;
import com.example.hw2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    @Override
    public Student getStudentById(String id){
        return studentRepo.getStudentById(id);
    }
    @Override
    public List<Student> getAllStudents(){
        return studentRepo.getAllStudents();
    }

    @Override
    public void updateStudent(String id, String name, List<String> listTeacherId){
        studentRepo.updateStudent(id, name, listTeacherId);
    }
}
