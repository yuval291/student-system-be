package com.example.login.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "students")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {

    @Id
    private String userId;
    private String password;
    private String first_name;
    private String last_name;
    private String email;

}
