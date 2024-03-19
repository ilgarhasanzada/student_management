package com.student_management.student_management.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.student_management.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT s FROM Student s")
    public List<Student> fetchAllFromCustom();

    @Query(value = "SELECT * FROM student WHERE (:firstName IS NULL OR first_name LIKE %:firstName%) " +
            "AND (:lastName IS NULL OR last_name LIKE %:lastName%) " +
            "AND (:email IS NULL OR email LIKE %:email%) " +
            "AND (:age IS NULL OR age = :age)",
            countQuery = "SELECT COUNT(*) FROM student WHERE (:firstName IS NULL OR first_name LIKE %:firstName%) " +
                    "AND (:lastName IS NULL OR last_name LIKE %:lastName%) " +
                    "AND (:email IS NULL OR email LIKE %:email%) " +
                    "AND (:age IS NULL OR age = :age)",
            nativeQuery = true)
    Page<Student> filterStudents(String firstName, String lastName, String email, Integer age, Pageable pageable);

    @Query(value = "SELECT * FROM student s INNER JOIN student_course sc ON s.id = sc.student_id WHERE sc.course_id = :courseId AND (:firstName IS NULL OR s.first_name LIKE %:firstName%) AND (:lastName IS NULL OR s.last_name LIKE %:lastName%) AND (:email IS NULL OR s.email LIKE %:email%) AND (:age IS NULL OR s.age = :age)",
        countQuery = "SELECT COUNT(*) FROM student s INNER JOIN student_course sc ON s.id = sc.student_id WHERE sc.course_id = :courseId AND (:firstName IS NULL OR s.first_name LIKE %:firstName%) AND (:lastName IS NULL OR s.last_name LIKE %:lastName%) AND (:email IS NULL OR s.email LIKE %:email%) AND (:age IS NULL OR s.age = :age)",
        nativeQuery = true)
    Page<Student> filterStudentsByCourse(Long courseId, String firstName, String lastName, String email, Integer age, Pageable pageable);
}
