package com.example.login.controllers;

import com.example.login.models.User;
import com.example.login.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.POST,RequestMethod.DELETE,RequestMethod.GET})
public class UserController {

    @Autowired
    private UserRepo repo;

    @PostMapping("/getDetail")
    //ResponseEntity represents the whole HTTP response: status code, headers, and body
    public ResponseEntity<User> getDetailUser(@RequestBody String userID){
        User user=repo.findByUserId(userID);
        return ResponseEntity.ok(user);
    }
}
