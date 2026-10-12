package com.management.org.student_coach_management.Coach;

import com.management.org.student_coach_management.Coach.Exception.CoachNotFoundException;
import com.management.org.student_coach_management.Coach.dto.CoachDTO;
import com.management.org.student_coach_management.Coach.entity.Coach;
import com.management.org.student_coach_management.Coach.mapper.CoachMapper;
import com.management.org.student_coach_management.Student.StudentRepository;
import com.management.org.student_coach_management.Student.dto.StudentDTO;
import com.management.org.student_coach_management.Student.entity.Student;
import com.management.org.student_coach_management.Student.mapper.StudentMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of CoachService. Coordinates repository access for Coach
 * operations and converts entities to DTOs for API responses.
 */
@Service
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;

    private final StudentRepository studentRepository;

    CoachServiceImpl(CoachRepository coachRepository, StudentRepository studentRepository) {
        this.coachRepository = coachRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public CoachDTO createCoach(CoachDTO coachDTO) {
        Coach coach = CoachMapper.toEntity(coachDTO);
        return CoachMapper.toDTO(coachRepository.save(coach));
    }

    @Override
    public List<CoachDTO> getCoaches(String searchText, Pageable pageable) {
        Specification<Coach> spec = CoachSpecification.searchAllFields(searchText);
        List<Coach> coaches = coachRepository.findAll(spec, pageable).getContent();
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

    /**
     * Return a page of StudentDTOs enrolled with the given coach id.
     */
    @Override
    public List<StudentDTO> getEnrolledStudents(Pageable pageable, int id) {
        Coach coach = coachRepository.findById((long) id).orElse(null);
        if (coach == null) {
            throw new CoachNotFoundException("Coach not found with id: " + id);
        }
        Page<Student> studentsPage = studentRepository.findByCoachId((long) id, pageable);
        return studentsPage.getContent()
                .stream()
                .map(StudentMapper::toDTO)
                .toList();

        /**
         coach.getStudents() is the @OneToMany mapped collection of Student entities
         that belong to this Coach. It simply returns a plain List<Student> containing
         all students linked to that coach.

         Before pagination:
         - You could directly stream over this List and convert each Student to a DTO.
         - This worked fine because you were always loading the entire collection in memory.

         After pagination:
         - coach.getStudents() still returns the full List, but it does not support Pageable.
         - You cannot call coach.getStudents(pageable) because the entity’s collection
         is not pageable — JPA does not slice the list automatically.
         - Pagination must be applied at the repository query level (e.g. findByCoachId(coachId, pageable)),
         so the database returns only the requested subset of students.
         - This ensures you fetch only the needed records instead of loading all students
         into memory and trying to paginate them manually.
         */

        //return coach.getStudents(pageable).getContent().stream().map(StudentMapper::toDTO).collect(Collectors.toList());
    }
}
