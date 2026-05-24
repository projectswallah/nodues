package com.hglsys.nodues.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

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

    @Column(length = 100)
    private String designation;

    @Column(nullable = false)
    private Boolean isActive = true;
}