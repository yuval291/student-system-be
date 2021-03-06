package com.example.login.repo;

import com.example.login.Response.CourseStudentResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class CourseRepoImpl implements CourseRepoInterf {
    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    String editQuery = "select new com.example.login.Response.CourseStudentResponse(b.grade,c.courseName,c.id, c.startDate,c.endDate) FROM  Student a INNER JOIN CourseStudent b ON a.userId= b.studentId INNER JOIN Course c ON c.id = b.courseId where a.userId = :id ";

    public List<CourseStudentResponse> GetCoursesInfo (String userId){
        List<CourseStudentResponse> courses = entityManager.createQuery(editQuery, CourseStudentResponse.class)
                .setParameter( "id", userId )
                .getResultList();

        return courses;
    }

}
