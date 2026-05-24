package com.hglsys.nodues.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false, unique = true, length = 50)
    private String prnNo;

    @Column(nullable = false, length = 150)
    private String firstName;

    @Column(nullable = false, length = 150)
    private String middleName;

    @Column(nullable = false, length = 150)
    private String lastName;


    @Column(unique = true, length = 150)
    private String email;

    @Column(unique = true, length = 15)
    private String mobile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(length = 50)
    private String semester;

    @Column(length = 50)
    private String academicYear;

    @Column(nullable = false)
    private Boolean isActive = true;
}
