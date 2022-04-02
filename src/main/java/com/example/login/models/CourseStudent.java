package com.example.login.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "course_student_system")
@AllArgsConstructor
@Data
@NoArgsConstructor
@IdClass(CourseUserId.class)
public class CourseStudent implements Serializable {
    @Id
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "course_id")
    @Id
    private String courseId;
    @Column(name = "grade")
    private Integer grade;
    @Column(name = "registration_date")
    private Date registrationDate;

}

