package com.management.org.student_coach_management.Student.mapper;

import com.management.org.student_coach_management.Student.dto.StudentDTO;
import com.management.org.student_coach_management.Student.entity.Student;

public class StudentMapper {
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
