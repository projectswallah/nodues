package com.hglsys.nodues.mapper;

import com.hglsys.nodues.Dto.departmentDto.DepartmentResponse;
import com.hglsys.nodues.entities.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentResponse toResponse(Department department);
}
