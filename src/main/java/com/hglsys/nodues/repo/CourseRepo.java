package com.hglsys.nodues.repo;

import com.hglsys.nodues.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    Optional<Course> findByCourseCode(String courseCode);
}
