package com.student_management.student_management.controller;

import com.student_management.student_management.model.Course;
import com.student_management.student_management.model.Student;
import com.student_management.student_management.service.CourseService;
import com.student_management.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService  courseService;
    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "students/index";
    }
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Student student) {
        // Yeni öğrenci ekleme işlemi burada gerçekleşecek
        studentService.addStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
    @PostMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        // studentService.updateStudent(student);
        return "redirect:/students";
    }

}