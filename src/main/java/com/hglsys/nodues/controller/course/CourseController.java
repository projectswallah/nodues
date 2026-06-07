package com.hglsys.nodues.controller.course;


import com.hglsys.nodues.Dto.ApiResponse;
import com.hglsys.nodues.Dto.courseDto.CourseRequest;
import com.hglsys.nodues.entities.Course;
import com.hglsys.nodues.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCourse(@Valid @RequestBody CourseRequest request){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(courseService.addCourse(request));
    }

}
