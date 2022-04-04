package com.example.hw2.service.impl;

import com.example.hw2.domain.Teacher;
import com.example.hw2.repository.TeacherRepo;
import com.example.hw2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo teacherRepo;
    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo){
        this.teacherRepo = teacherRepo;
    }

    @Override
    public Teacher getTeacherById(String id){
        return teacherRepo.getTeacherById(id);
    }

    @Override
    public List<Teacher> getAllTeachers(){
        return teacherRepo.getAllTeachers();
    }

    @Override
    public void updateTeacher(String id, String name, List<String> listStudentId){
        teacherRepo.updateTeacher(id, name, listStudentId);
    }


}
