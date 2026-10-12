package com.management.org.student_coach_management.Student;

import com.management.org.student_coach_management.Student.dto.StudentDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Service interface that defines student-related operations.
 * Implementations should handle business rules, validation and mapping
 * between entities and DTOs.
 */
public interface StudentService {

    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getStudents(String firstName, String lastName, String major, String email, Pageable pageable);

    StudentDTO getStudent(int id);

    StudentDTO updateStudent(int id, StudentDTO studentDTO);

    void deleteStudent(int id);
}
