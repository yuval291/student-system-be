package com.example.login.repo;

import com.example.login.Response.CourseStudentResponse;

import javax.transaction.Transactional;
import java.util.List;

public interface CourseRepoInterf {
    List<CourseStudentResponse> GetCoursesInfo (String userId);

    @Transactional
    Boolean DeleteCourse(String courseId, String userId);
}
