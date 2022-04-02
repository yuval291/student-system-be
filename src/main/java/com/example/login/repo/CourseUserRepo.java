package com.example.login.repo;

import com.example.login.models.CourseUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CourseUserRepo  extends CrudRepository<CourseUser, String> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CourseUser where courseId = ?1 and studentId = ?2")
    int customDeleteByCourseAndUserIds(String courseId , String userId);
}
