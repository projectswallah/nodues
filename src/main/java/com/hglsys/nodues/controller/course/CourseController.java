package com.hglsys.nodues.controller.course;

import com.hglsys.nodues.Dto.ApiResponse;
import com.hglsys.nodues.Dto.PagedResponse;
import com.hglsys.nodues.Dto.courseDto.CourseRequest;
import com.hglsys.nodues.Dto.courseDto.CourseResponse;
import com.hglsys.nodues.Dto.courseDto.CourseUpdateRequest;
import com.hglsys.nodues.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@PreAuthorize("hasRole('PRINCIPAL')")
public class CourseController {

    private final CourseService courseService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCourse(@Valid @RequestBody CourseRequest request){
        return ResponseEntity.ok(courseService.create(request));
    }

    @PutMapping("/edit")
    public ResponseEntity<ApiResponse> editCourse(@Valid @RequestBody CourseUpdateRequest request){
        return ResponseEntity.ok(courseService.update(request));
    }

    @GetMapping("/view")
    public ResponseEntity<PagedResponse<CourseResponse>> getAll( @PageableDefault(size = 10, sort = "courseId") Pageable pageable) {
        return ResponseEntity.ok(courseService.fetchAll(pageable));
    }

    @GetMapping("/view/{code}")
    public ResponseEntity<ApiResponse<CourseResponse>> getByCourseCode(
            @PathVariable String code) {

        return ResponseEntity.ok(
                courseService.fetchByCourseCode(code.toUpperCase())
        );
    }
}
