package com.management.org.student_coach_management.Coach;

import com.management.org.student_coach_management.Coach.dto.CoachDTO;
import com.management.org.student_coach_management.Student.dto.StudentDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CoachService {

    CoachDTO createCoach(@Valid CoachDTO coachDTO);

    List<CoachDTO> getCoaches(Pageable pageable);

    CoachDTO getCoachById(int id);

    CoachDTO updateCoach(int id, @Valid CoachDTO coachDTO);

    CoachDTO deleteCoach(int id);

    List<StudentDTO> getEnrolledStudents(Pageable pageable, int id);

}
