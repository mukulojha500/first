package com.learning.first.controllers;

import com.learning.first.models.Teacher;
import com.learning.first.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController{
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable String id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        return teacherOptional.orElse(null); // or handle appropriately if not present
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherRepository.save(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable String id){
        teacherRepository.deleteById(id);
    }

}