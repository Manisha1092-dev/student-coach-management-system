package com.management.org.student_coach_management.Coach;

import com.management.org.student_coach_management.Coach.dto.CoachDTO;
import com.management.org.student_coach_management.Coach.entity.Coach;
import com.management.org.student_coach_management.Student.entity.Student;
import jakarta.validation.Valid;

import java.util.List;

public interface CoachService {

    CoachDTO createCoach(@Valid CoachDTO coachDTO);

    List<CoachDTO> getCoaches();

    CoachDTO getCoachById(int id);

    CoachDTO updateCoach(int id, @Valid CoachDTO coachDTO);

    CoachDTO deleteCoach(int id);

    List<Student> getEnrolledStudents(int id);
}
