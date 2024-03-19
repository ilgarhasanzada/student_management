package com.student_management.student_management.controller;

import com.student_management.student_management.model.Course;
import com.student_management.student_management.model.Student;
import com.student_management.student_management.service.StudentService;
import com.student_management.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public String showCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses/index";
    }

    @GetMapping("/create_course")
    public String showCreateCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "courses/create_course";
    }

    @PostMapping("/create_course")
    public String createCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/";
    }
}