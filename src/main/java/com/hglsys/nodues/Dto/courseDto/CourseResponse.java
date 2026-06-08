package com.hglsys.nodues.Dto.courseDto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private Long courseId;
    private String courseCode;
    private String courseName;
    private String description;
    private Integer durationYears;
    private Boolean active;
}
