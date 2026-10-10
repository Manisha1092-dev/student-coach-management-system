package com.management.org.student_coach_management.Coach;

import com.management.org.student_coach_management.Coach.Exception.CoachNotFoundException;
import com.management.org.student_coach_management.Coach.dto.CoachDTO;
import com.management.org.student_coach_management.Coach.entity.Coach;
import com.management.org.student_coach_management.Coach.mapper.CoachMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;

    CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public CoachDTO createCoach(CoachDTO coachDTO) {
        Coach coach = CoachMapper.toEntity(coachDTO);
        return CoachMapper.toDTO(coachRepository.save(coach));
    }

    @Override
    public List<CoachDTO> getCoaches() {
        List<Coach> coaches = coachRepository.findAll();
        return coaches.stream().map(CoachMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CoachDTO getCoachById(int id) {
        Coach coach = coachRepository.findById((long) id).orElse(null);
        if (coach == null) {
            throw new CoachNotFoundException("Coach not found with id: " + id);
        }
        return CoachMapper.toDTO(coach);
    }

    @Override
    public CoachDTO updateCoach(int id, CoachDTO coachDTO) {
        Coach existingCoach = coachRepository.findById((long) id).orElse(null);
        if (existingCoach == null) {
            throw new CoachNotFoundException("Coach not found with id: " + id);
        }
        existingCoach.setFirstName(coachDTO.getFirstName());
        existingCoach.setLastName(coachDTO.getLastName());
        existingCoach.setSpecialty(coachDTO.getSpecialty());
        existingCoach.setExperience(coachDTO.getExperienceYears());
        existingCoach.setEmail(coachDTO.getEmail());
        coachRepository.save(existingCoach);
        return CoachMapper.toDTO(existingCoach);
    }

    @Override
    public CoachDTO deleteCoach(int id) {
        Coach coach = coachRepository.findById((long) id).orElse(null);
        if (coach == null) {
            throw new CoachNotFoundException("Coach not found with id: " + id);
        }
        coachRepository.delete(coach);
        return CoachMapper.toDTO(coach);
    }
}
