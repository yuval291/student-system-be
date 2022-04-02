package com.example.login.repo;

import com.example.login.models.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepo  extends CrudRepository<Student, String>{

    Student findByUserId(String username);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Student SET userId= ?1 , password = ?2, first_name= ?3 , last_name= ?4 , email=?5 WHERE userId = ?1")
    int saveEdit(String id, String pass, String first_name, String last_name, String email);
}
