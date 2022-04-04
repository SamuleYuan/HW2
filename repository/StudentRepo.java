package com.example.hw2.repository;

import com.example.hw2.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepo {

    private Map<String, Student> studentMap = new HashMap<>();
    public StudentRepo(){
        studentMap.put("1", new Student("1", "Tom", Arrays.asList("1", "2")));
        studentMap.put("2", new Student("2","Jerry", Arrays.asList("2", "3")));
    }
    public Student getStudentById(String id){
        return studentMap.get(id);
    }
    public List<Student> getAllStudents(){
        return (List)studentMap.values();
    }
    public void updateStudent(String id, String name, List<String> listTeacherId){
        studentMap.put(id, new Student(id, name, listTeacherId));
    }
}
