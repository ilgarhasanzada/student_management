package com.student_management.student_management.service;

import com.student_management.student_management.model.Student;
import com.student_management.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

//    public List<Student> getAllStudents() {
//        return studentRepository.fetchAllFromCustom();
//    }
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
    public Page<Student> filterStudents(Pageable pageable, Long courseId, String firstName, String lastName, String email, Integer age) {
        if (courseId == null){
            return studentRepository.filterStudents(firstName, lastName, email, age, pageable);
        }
        return studentRepository.filterStudentsByCourse(courseId,
                firstName, lastName, email, age, pageable);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}