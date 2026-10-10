package com.management.org.student_coach_management.Coach.mapper;

import com.management.org.student_coach_management.Coach.dto.CoachDTO;
import com.management.org.student_coach_management.Coach.entity.Coach;
import jakarta.validation.Valid;

/**
 * Mapper utility for converting between Coach entities and CoachDTOs.
 */
public class CoachMapper {


        /** Convert incoming CoachDTO into a Coach entity for persistence. */
    public static Coach toEntity(@Valid CoachDTO coachDTO) {
        return Coach.builder()
                .firstName(coachDTO.getFirstName())
                .lastName(coachDTO.getLastName())
                .specialty(coachDTO.getSpecialty())
                .experience(coachDTO.getExperienceYears())
                .email(coachDTO.getEmail())
                .build();
    }

        /** Convert Coach entity to CoachDTO for API responses. */
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
