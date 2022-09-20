package com.practice.StudentList.controller;

import com.practice.StudentList.entity.Student;
import com.practice.StudentList.exception.StudentNotFoundException;
import com.practice.StudentList.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping(value = "/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody @Valid Student student) {
        return new ResponseEntity<>(service.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getStudents")
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(service.getStudents());
    }

    @GetMapping(value = "/getStudentById/{id}")
    public Object findStudentById(@PathVariable int id) throws StudentNotFoundException {
        return (Object) service.getStudentById(id);
    }

    @PutMapping(value = "/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody @Valid Student student) {
        return ResponseEntity.ok(service.updateStudent(student));
    }

    @DeleteMapping(value = "/deleteStudentById/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable @Valid int id)  {
        return ResponseEntity.ok(service.deleteStudent(id));
    }
}
