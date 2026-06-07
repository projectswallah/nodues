package com.hglsys.nodues.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.hglsys.nodues.Dto.ApiResponse;
import com.hglsys.nodues.Dto.courseDto.CourseRequest;
import com.hglsys.nodues.entities.Course;
import com.hglsys.nodues.repo.CourseRepo;
import com.hglsys.nodues.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public ApiResponse addCourse(CourseRequest request) {

        Course course = new Course();
        BeanUtils.copyProperties(request,course);
        Course savedCourse = courseRepo.save(course);

        return new ApiResponse(
                201,
                "Course added successfully.",
                savedCourse
        );
    }
}
