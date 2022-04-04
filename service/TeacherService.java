package com.example.hw2.service;

import com.example.hw2.domain.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    Teacher getTeacherById(String id);

    List<Teacher> getAllTeachers();
    void updateTeacher(String id, String name, List<String> listStudentId);

}
