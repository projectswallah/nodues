package com.hglsys.nodues.repo;

import com.hglsys.nodues.Dto.departmentDto.DepartmentResponse;
import com.hglsys.nodues.entities.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDepartmentCode(String departmentCode);

    Page<Department> findAllByActiveTrue(Pageable pageable);
    boolean existsByDepartmentCode(String departmentCode);
}
