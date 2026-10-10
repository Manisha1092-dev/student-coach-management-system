package com.management.org.student_coach_management.Coach.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor       // generates empty constructor
@AllArgsConstructor      // generates constructor with all fields
@Builder                 // generates builder() method
public class CoachDTO {

    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Specialty is required")
    private String specialty;
    private int experienceYears;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

}
