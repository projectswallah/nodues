package com.hglsys.nodues.service.impl;

import com.hglsys.nodues.Dto.ApiResponse;
import com.hglsys.nodues.Dto.PagedResponse;
import com.hglsys.nodues.Dto.departmentDto.DepartmentRequest;
import com.hglsys.nodues.Dto.departmentDto.DepartmentResponse;
import com.hglsys.nodues.Dto.departmentDto.DepartmentUpdateRequest;
import com.hglsys.nodues.entities.Department;
import com.hglsys.nodues.exceptions.BadRequestException;
import com.hglsys.nodues.exceptions.ResourceNotFoundException;
import com.hglsys.nodues.mapper.DepartmentMapper;
import com.hglsys.nodues.repo.DepartmentRepository;
import com.hglsys.nodues.service.DepartmentService;
import com.hglsys.nodues.utility.PaginationUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public ApiResponse create(DepartmentRequest dto) {

        if (departmentRepository.existsByDepartmentCode(dto.getDepartmentCode())) {
            throw new BadRequestException("Department code already exists");
        }
        Department department = new Department();
        BeanUtils.copyProperties(dto, department);
        department = departmentRepository.save(department);

        return new ApiResponse(
                200, "Created", department
        );
    }

    @Override
    public ApiResponse edit(DepartmentUpdateRequest dto) {

        Department department = departmentRepository.findById(dto.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        BeanUtils.copyProperties(dto, department);
        department = departmentRepository.save(department);

        ApiResponse response = new ApiResponse(201, "Department Updated successfully", department);
        return response;
    }

    @Override
    public ApiResponse inactive(long id) {

        Department department = departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Department not found"));

        department.setActive(false);
        departmentRepository.save(department);

        return new ApiResponse(200,"Department deleted.",department);
    }

    @Override
    public PagedResponse getAll(Pageable pageable) {

        Page<DepartmentResponse> page = departmentRepository.findAll(pageable).map(departmentMapper::toResponse);
        return PaginationUtil.toPagedResponse(page);
    }

    @Override
    public PagedResponse getActiveAll(Pageable pageable) {
        Page<DepartmentResponse> page = departmentRepository.findAllByActiveTrue(pageable).map(departmentMapper::toResponse);
        return PaginationUtil.toPagedResponse(page);
    }

    @Override
    public DepartmentResponse fetchByDepartmentCode(String departmentCode) {

        DepartmentResponse departmentResponse = new DepartmentResponse();

        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(()->new ResourceNotFoundException("Department not found."));
        BeanUtils.copyProperties(department,departmentResponse);
        return departmentResponse;
    }


}