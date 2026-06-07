package com.hglsys.nodues.Dto.courseDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CourseRequest {

    @NotBlank(message = "Course code is required.")
    @Size(max = 10, message = "Course code cannot exceed 10 characters.")
    private String courseCode;

    @NotBlank(message = "Course name is required.")
    @Size(max = 100, message = "Course name cannot exceed 100 characters.")
    private String courseName;

    @Size(max = 200, message = "Description cannot exceed 200 characters.")
    private String description;
}
