package com.hglsys.nodues.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.hglsys.nodues.Dto.ApiResponse;
import com.hglsys.nodues.Dto.ErrorResponse;
import com.hglsys.nodues.Dto.PagedResponse;
import com.hglsys.nodues.Dto.courseDto.CourseRequest;
import com.hglsys.nodues.Dto.courseDto.CourseResponse;
import com.hglsys.nodues.Dto.courseDto.CourseUpdateRequest;
import com.hglsys.nodues.entities.Course;
import com.hglsys.nodues.exceptions.ResourceNotFoundException;
import com.hglsys.nodues.mapper.CourseMapper;
import com.hglsys.nodues.repo.CourseRepo;
import com.hglsys.nodues.service.CourseService;
import com.hglsys.nodues.utility.PaginationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;

    @Override
    public ApiResponse create(CourseRequest request) {

        Course course = new Course();
        BeanUtils.copyProperties(request,course);
        Course savedCourse = courseRepo.save(course);

        return new ApiResponse(
                201,
                "Course added successfully.",
                savedCourse
        );
    }

    @Override
    public ApiResponse update(CourseUpdateRequest request) {

        Course course =courseRepo.findById(request.getId()).orElseThrow(()-> new ResourceNotFoundException("Course not found!"));

        courseMapper.updateCourseFromDto(request, course);

        Course savedCourse = courseRepo.save(course);

        return new ApiResponse(
                200,
                "Course updated successfully.",
                savedCourse
        );
    }

    @Override
    public PagedResponse<CourseResponse> fetchAll(Pageable pageable) {

        Page<CourseResponse> courses = courseRepo.findAll(pageable)
                .map(courseMapper::toResponse);

        return PaginationUtil.toPagedResponse(courses);
    }

    @Override
    public ApiResponse fetchByCourseCode(String code) {
        Course course = courseRepo.findByCourseCode(code)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found."));

        return new ApiResponse<>(
                200,
                "Course fetched successfully.",
                courseMapper.toResponse(course)
        );
    }
}
