package com.student_management.student_management.controller;

import com.student_management.student_management.model.Course;
import com.student_management.student_management.model.Student;
import com.student_management.student_management.service.CourseService;
import com.student_management.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService  courseService;
    @GetMapping("/students")
    public String listStudents(Model model,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "2") int size,
                               @RequestParam(defaultValue = "id") String sortBy,
                               @RequestParam(defaultValue = "asc") String direction,
                               @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String lastName,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) Integer age,
                               @RequestParam(required = false) Long courseId) {

        Sort.Direction sortDirection = direction.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

        Page<Student> studentsPage;

        if (firstName != null && !firstName.isEmpty() || lastName != null && !lastName.isEmpty() || email != null && !email.isEmpty() || age != null || courseId != null) {
            studentsPage = studentService.filterStudents(pageable,courseId, firstName, lastName, email, age);
            model.addAttribute("firstName", firstName);
            model.addAttribute("lastName", lastName);
            model.addAttribute("email", email);
            model.addAttribute("age", age);
            model.addAttribute("courseId", courseId);

        } else {
            studentsPage = studentService.getAllStudents(pageable);
        }
        model.addAttribute("students", studentsPage.getContent());
        model.addAttribute("totalPages", studentsPage.getTotalPages());
        model.addAttribute("currentPage", studentsPage.getNumber());

        model.addAttribute("sortBy", sortBy);
        model.addAttribute("direction", direction);

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