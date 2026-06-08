package com.hglsys.nodues.mapper;

import com.hglsys.nodues.Dto.courseDto.CourseResponse;
import com.hglsys.nodues.Dto.courseDto.CourseUpdateRequest;
import com.hglsys.nodues.entities.Course;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE
    )
    void updateCourseFromDto(
            CourseUpdateRequest dto,
            @MappingTarget Course entity
    );

    CourseResponse toResponse(Course course);
}
