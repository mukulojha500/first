package com.learning.first.controllers;

import org.springframework.web.bind.annotation.*;

import com.learning.first.models.Student;
import com.learning.first.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired(required = true)
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.orElse(null); // or handle appropriately if not present
    }


    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    // @PutMapping("{/id}")
    // public Student updateStudent(@PathVariable String id, @RequestBody Student student){
    //     Student std = studentRepository.findById(id);
    //     std.setId(student.getId());
    //     std.setName(student.getName());
    //     std.setAge(student.getAge());

    //     return studentRepository.save(std);
    // }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id){
        studentRepository.deleteById(id);
    }
}