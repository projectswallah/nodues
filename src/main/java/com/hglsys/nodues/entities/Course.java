package com.hglsys.nodues.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mst_courses")
@Data
public class Course extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false, unique = true)
    private String courseCode;

    @Column(nullable = false)
    private String courseName;

    private String description;

    private Integer durationYears;

    private Boolean active = true;
}
