package com.example.login.controllers;

import com.example.login.models.Course;
import com.example.login.models.CourseResponse;
import com.example.login.models.CourseUser;
import com.example.login.models.User;
import com.example.login.repo.CourseRepo;
import com.example.login.repo.CourseUserRepo;
import com.example.login.repo.UserRepo;
import com.example.login.types.DeleteRequestObject;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.POST,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.PUT})
public class UserController {

    @Autowired
    private UserRepo repo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseUserRepo courseUserRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/getDetail")
    //ResponseEntity represents the whole HTTP response: status code, headers, and body
    public ResponseEntity<User> getDetailUser(@RequestBody String userID){
        User user=repo.findByUserId(userID);
        return ResponseEntity.ok(user);
    }

        @PostMapping("/saveEdit")
    public boolean saveEdit(@RequestBody User userEdit){
        String id= userEdit.getUserId();
        String first_name= userEdit.getFirst_name();
        String last_name= userEdit.getLast_name();
        String email= userEdit.getEmail();
        String pass= userEdit.getPassword();

        System.out.println(id+" "+pass+" "+first_name+" "+last_name+" "+email);
        int res= repo.saveEdit(id,pass,first_name,last_name,email);
        System.out.println("res = "+ res);
        if(res==1)
        {
            return true;
        }
        return false;
    }

    @PostMapping("/getCourses")
    public List<CourseResponse> getUserCourses(@RequestBody String userID) {
        List<CourseResponse> coursesList = courseRepo.GetCoursesInfo(userID);
        return  coursesList;
    }

    @PostMapping("/deleteCourse")
    public Boolean onDeleteCourse(@RequestBody DeleteRequestObject deleteReq) {

        int res =courseUserRepo.customDeleteByCourseAndUserIds(deleteReq.courseId,deleteReq.userId);
        if(res==1){
            return true;
        }
        return false;
    }


}
