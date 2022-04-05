package com.example.login.controllers;

import com.example.login.Response.CourseStudentResponse;
import com.example.login.models.Student;
import com.example.login.repo.CourseRepo;
import com.example.login.repo.CourseUserRepo;
import com.example.login.repo.UserRepo;
import com.example.login.types.DeleteRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    @PostMapping("/getDetail")
    //ResponseEntity represents the whole HTTP response: status code, headers, and body
    public ResponseEntity<Student> getDetailUser(@RequestBody String userID){
        Student user=repo.findByUserId(userID);
        return ResponseEntity.ok(user);
    }

        @PostMapping("/saveEdit")
    public boolean saveEdit(@RequestBody Student userEdit){
        String id= userEdit.getUserId();
        String first_name= userEdit.getFirst_name();
        String last_name= userEdit.getLast_name();
        String email= userEdit.getEmail();
        String pass= userEdit.getPassword();

        int res= repo.saveEdit(id,pass,first_name,last_name,email);
        if(res==0)
        {
            return false;
        }
        return true;
    }

    @PostMapping("/getCourses")
    public List<CourseStudentResponse> getUserCourses(@RequestBody String userID) {
        List<CourseStudentResponse> coursesList = courseRepo.GetCoursesInfo(userID);
        return  coursesList;
    }

    @PostMapping("/deleteCourse")
    public Boolean onDeleteCourse(@RequestBody DeleteRequestObject deleteReq) {

        int res =courseUserRepo.customDeleteByCourseAndUserIds(deleteReq.courseId,deleteReq.userId);
        if(res==0){
            return false;
        }
        return true;
    }


}
