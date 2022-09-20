package com.practice.StudentList.repository;

import com.practice.StudentList.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> getStudents();

    Object getStudentById(int id);

    @Query(value = "SELECT * FROM students_data WHERE name = Sandipan Seal", nativeQuery = true)
    List<Student> fetchStudent (String email_id);
}
