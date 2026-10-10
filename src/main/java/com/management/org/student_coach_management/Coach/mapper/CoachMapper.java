package com.management.org.student_coach_management.Coach.mapper;

import com.management.org.student_coach_management.Coach.dto.CoachDTO;
import com.management.org.student_coach_management.Coach.entity.Coach;
import jakarta.validation.Valid;

public class CoachMapper {


    public static Coach toEntity(@Valid CoachDTO coachDTO) {
        return Coach.builder()
                .firstName(coachDTO.getFirstName())
                .lastName(coachDTO.getLastName())
                .specialty(coachDTO.getSpecialty())
                .experience(coachDTO.getExperienceYears())
                .email(coachDTO.getEmail())
                .build();
    }

    public static CoachDTO toDTO(Coach coach) {
        return CoachDTO.builder()
                .firstName(coach.getFirstName())
                .lastName(coach.getLastName())
                .specialty(coach.getSpecialty())
                .experienceYears(coach.getExperience())
                .email(coach.getEmail())
                .build();
    }

}
