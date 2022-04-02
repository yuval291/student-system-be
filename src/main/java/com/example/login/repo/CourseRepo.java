package com.example.login.repo;

import com.example.login.models.Course;
import com.example.login.models.CourseResponse;
import com.example.login.models.User;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Repository
public interface CourseRepo extends CrudRepository<Course, String>,CourseRepoInterf {




}
