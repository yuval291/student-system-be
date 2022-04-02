package com.example.login.models;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

//DTO- DATA TRANSFER OBJECT
public class CourseResponse implements Serializable {
    private String id;
    private String courseName;
    private Integer  grade;
    private Date startDate;
    private Date endDate;
    public CourseResponse(){}
    public CourseResponse(Integer grade, String courseName, String id , Date startDate, Date endDate) {
        this.grade=grade;
        this.courseName=courseName;
        this.endDate=endDate;
        this.startDate=startDate;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
