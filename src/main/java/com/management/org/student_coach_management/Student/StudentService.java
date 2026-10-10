package com.management.org.student_coach_management.Student;

import com.management.org.student_coach_management.Student.dto.StudentDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getStudents(Pageable pageable);

    StudentDTO getStudent(int id);

    StudentDTO updateStudent(int id, StudentDTO studentDTO);

    void deleteStudent(int id);
}
