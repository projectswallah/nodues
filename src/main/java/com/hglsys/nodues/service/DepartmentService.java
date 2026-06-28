package com.hglsys.nodues.service;

import com.hglsys.nodues.Dto.ApiResponse;
import com.hglsys.nodues.Dto.PagedResponse;
import com.hglsys.nodues.Dto.departmentDto.DepartmentRequest;
import com.hglsys.nodues.Dto.departmentDto.DepartmentResponse;
import com.hglsys.nodues.Dto.departmentDto.DepartmentUpdateRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {

    ApiResponse create (DepartmentRequest dto) ;


    ApiResponse edit(DepartmentUpdateRequest dto);

    ApiResponse inactive (long id);

    PagedResponse getAll(Pageable pageable);

    PagedResponse getActiveAll(Pageable pageable);
    DepartmentResponse fetchByDepartmentCode(String departmentCode);

}
