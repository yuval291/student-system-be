package com.example.login.repo;

import com.example.login.models.CourseStudent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface CourseUserRepo  extends CrudRepository<CourseStudent, String> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CourseStudent where courseId = ?1 and studentId = ?2")
    int customDeleteByCourseAndUserIds(String courseId , String userId);
}
