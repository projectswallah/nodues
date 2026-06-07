package com.hglsys.nodues.service;

import com.hglsys.nodues.Dto.ApiResponse;
import com.hglsys.nodues.Dto.courseDto.CourseRequest;
import com.hglsys.nodues.entities.Course;

public interface CourseService {

    ApiResponse addCourse(CourseRequest request);


}
