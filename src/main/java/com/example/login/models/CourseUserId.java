package com.example.login.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;


public class CourseUserId implements Serializable {
    private String studentId;
    private String courseId;
}
