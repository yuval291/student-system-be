package com.example.login.repo;

import com.example.login.models.CourseResponse;

import javax.transaction.Transactional;
import java.util.List;

public interface CourseRepoInterf {
    List<CourseResponse> GetCoursesInfo (String userId);

    @Transactional
    Boolean DeleteCourse(String courseId, String userId);
}
