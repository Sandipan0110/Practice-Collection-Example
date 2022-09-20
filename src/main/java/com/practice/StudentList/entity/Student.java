package com.practice.StudentList.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students_data")

public class Student {
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
