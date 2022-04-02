package com.example.login.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "students")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private String userId;

    private String password;
    private String first_name;
    private String last_name;
    private String email;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "course_student_system",
        joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "user_id", nullable = false , updatable = false),
        },
        inverseJoinColumns = {
            @JoinColumn(name = "course_id",referencedColumnName = "id", nullable = false , updatable = false)
    })
    private List<Course> courses =  new ArrayList<>();


}
