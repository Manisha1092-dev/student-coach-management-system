package com.management.org.student_coach_management.Student.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Enrollment date is mandatory")
    private Date enrollmentDate;

    @NotBlank(message = "Major is mandatory")
    private String major;

    @NotBlank(message = "Coach ID is mandatory")
    private int coachId;
    
}
