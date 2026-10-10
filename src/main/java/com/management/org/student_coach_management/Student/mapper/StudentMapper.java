package com.management.org.student_coach_management.Student.mapper;

import com.management.org.student_coach_management.Student.dto.StudentDTO;
import com.management.org.student_coach_management.Student.entity.Student;

/**
 * Utility mapper for converting between Student entity and StudentDTO.
 * Mappers keep conversion logic in a single place and keep services/controllers clean.
 */
public class StudentMapper {
        /** Convert Student entity to StudentDTO for API responses. */
    public static StudentDTO toDTO(Student student) {

        return StudentDTO.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .enrollmentDate(student.getEnrollmentDate())
                .major(student.getMajor())
                .coachId(student.getCoachId())
                .build();
    }

        /** Convert incoming StudentDTO into a Student entity for persistence. */
    public static Student toEntity(StudentDTO studentDTO) {
        return Student.builder()
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .email(studentDTO.getEmail())
                .enrollmentDate(studentDTO.getEnrollmentDate())
                .major(studentDTO.getMajor())
                .coachId(studentDTO.getCoachId())
                .build();
    }
}
