package com.example.hw2.repository;

import com.example.hw2.domain.Student;
import com.example.hw2.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TeacherRepo {

    private Map<String, Teacher> teacherMap = new HashMap<>();
    public TeacherRepo(){
        teacherMap.put("1", new Teacher("1", "Kong", Arrays.asList("1")));
        teacherMap.put("2", new Teacher("2","Max", Arrays.asList("1", "2")));
        teacherMap.put("3", new Teacher("3", "Sam", Arrays.asList("2")));
    }
    public Teacher getTeacherById(String id){
        return teacherMap.get(id);
    }

    public List<Teacher> getAllTeachers(){
        return (List)teacherMap.values();
    }

    public void updateTeacher(String id, String name, List<String> listStudentId){
        teacherMap.put(id, new Teacher(id, name, listStudentId));
    }

}
