package com.example.login.repo;

import com.example.login.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends CrudRepository<Course, String>,CourseRepoInterf {




}
