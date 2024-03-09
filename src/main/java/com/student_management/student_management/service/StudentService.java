package com.student_management.student_management.service;

import com.student_management.student_management.model.Student;
import com.student_management.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.fetchAllFromCustom();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
//    public void updateStudent(Student student) {
//        if (student.getId() != null) {
//            Optional<Student> existingStudentOptional = studentRepository.findById(student.getId());
//            if (existingStudentOptional.isPresent()) {
//                Student existingStudent = existingStudentOptional.get();
//                existingStudent.setFirst_name(student.getFirst_name());
//                existingStudent.setLast_name(student.getLast_name());
//                existingStudent.setEmail(student.getEmail());
//                existingStudent.setAge(student.getAge());
//                studentRepository.save(existingStudent);
//            } else {
//                throw new RuntimeException("Student not found with id: " + student.getId());
//            }
//        } else {
//            throw new IllegalArgumentException("Student ID cannot be null for update operation");
//        }
//    }
}