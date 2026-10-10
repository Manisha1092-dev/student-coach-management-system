package com.management.org.student_coach_management.Student;

import aj.org.objectweb.asm.commons.Remapper;
import com.management.org.student_coach_management.Student.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getStudents();

    StudentDTO getStudent(int id);

    StudentDTO updateStudent(int id, StudentDTO studentDTO);

    void deleteStudent(int id);
}
