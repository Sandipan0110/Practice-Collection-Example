package com.practice.StudentList.service;

import com.practice.StudentList.entity.Student;
import com.practice.StudentList.exception.StudentNotFoundException;
import com.practice.StudentList.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return (Student) repository.save(student);
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Object getStudentById(int id) throws StudentNotFoundException {
        Object student  = repository.findById(id);
        if(student != null) {
            return student;
        } else {
            throw new StudentNotFoundException("You Have Entered Invalid Id :: "+id);
        }
    }

    public Student updateStudent(Student student) {
        Student existingStudent = repository.findById(student.getId()).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setMobile_no(student.getMobile_no());
        existingStudent.setEmail_id(student.getEmail_id());
        existingStudent.setDept_id(student.getDept_id());
        existingStudent.setDept_name(student.getDept_name());
        return repository.save(existingStudent);
    }

    public String deleteStudent(int id) {
        repository.deleteById(id);
        return "Student Removed Successfully... " + id;
    }
}
