package com.hglsys.nodues.Dto.courseDto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseUpdateRequest {

    private Long Id;

    @NotBlank(message = "Course code is required.")
    @Size(max = 10, message = "Course code cannot exceed 10 characters.")
    private String courseCode;

    @NotBlank(message = "Course name is required.")
    @Size(max = 100, message = "Course name cannot exceed 100 characters.")
    private String courseName;

    @Size(max = 200, message = "Description cannot exceed 200 characters.")
    private String description;

    @NotNull(message = "Duration cannot be null.")
    @Min(value = 1, message = "Duration must be at least 1 year.")
    @Max(value = 9, message = "Duration cannot exceed 9 years.")
    private Integer durationYears;


    private Boolean active;
}
