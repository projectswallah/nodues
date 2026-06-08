package com.hglsys.nodues.service;

import com.hglsys.nodues.Dto.ApiResponse;
import com.hglsys.nodues.Dto.PagedResponse;
import com.hglsys.nodues.Dto.courseDto.CourseRequest;
import com.hglsys.nodues.Dto.courseDto.CourseResponse;
import com.hglsys.nodues.Dto.courseDto.CourseUpdateRequest;
import com.hglsys.nodues.entities.Course;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {

    ApiResponse create(CourseRequest request);

    ApiResponse update(CourseUpdateRequest request);

    PagedResponse<CourseResponse> fetchAll(Pageable pageable);

    ApiResponse fetchByCourseCode(String code);
}
