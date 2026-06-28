package com.hglsys.nodues.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mst_departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(nullable = false, unique = true, length = 50)
    private String departmentCode;

    @Column(nullable = false, length = 100)
    private String departmentName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Boolean active = true;
}