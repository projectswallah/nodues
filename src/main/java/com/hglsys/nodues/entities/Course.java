package com.hglsys.nodues.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mst_courses")
public class Course extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false, unique = true)
    private String courseCode;

    @Column(nullable = false)
    private String courseName;

    private Integer durationYears;

    private Boolean isActive = true;
}
