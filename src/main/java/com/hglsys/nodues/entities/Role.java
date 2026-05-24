package com.hglsys.nodues.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mst_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(nullable = false, unique = true, length = 50)
    private String roleCode;

    @Column(nullable = false, length = 100)
    private String roleName;

    @Column(nullable = false)
    private Boolean isActive = true;
}