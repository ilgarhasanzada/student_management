package com.student_management.student_management.service;

import com.student_management.student_management.model.Course;
import com.student_management.student_management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.fetchAllFromCustom();
    }

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> getCoursesByIds(Set<Long> courseIds) {
        return courseRepository.findAllById(courseIds);
    }
}