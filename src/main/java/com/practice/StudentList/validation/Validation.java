package com.practice.StudentList.validation;

import com.practice.StudentList.entity.Student;
import com.sun.istack.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Validation extends Student {

    @Id
    @GeneratedValue
    int id;
    @NotNull
    @Size(min = 2, max = 30)
    String name;
    @NotNull
    @Pattern(regexp = "^\\d{10}$")
    String mobile_no;
    @Email
    String email_id;
    @NotNull
    @Size(min = 3, max = 10)
    String dept_id;
    @NotEmpty
    String dept_name;
}
