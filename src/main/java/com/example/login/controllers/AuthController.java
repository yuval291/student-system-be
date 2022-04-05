package com.example.login.controllers;

import com.example.login.models.Student;
import com.example.login.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.POST,RequestMethod.DELETE,RequestMethod.GET})
public class AuthController {

    @Autowired
    private UserRepo repo;

    @PostMapping("/login")
    //ResponseEntity represents the whole HTTP response: status code, headers, and body
    public ResponseEntity<Student> loginUser(@RequestBody Student userData){
        Student user=repo.findByUserId(userData.getUserId());
        if(user.getPassword().equals(userData.getPassword())){
            return ResponseEntity.ok(user);
        }
        return (ResponseEntity<Student>) ResponseEntity.internalServerError();
    }
}
