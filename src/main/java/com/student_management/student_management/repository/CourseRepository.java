package com.student_management.student_management.repository;

import com.student_management.student_management.model.Course;
import com.student_management.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(value = "SELECT c FROM Course c")
    public List<Course> fetchAllFromCustom();
}