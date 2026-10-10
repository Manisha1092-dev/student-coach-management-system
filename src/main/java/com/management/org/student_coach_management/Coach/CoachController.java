package com.management.org.student_coach_management.Coach;

import com.management.org.student_coach_management.Coach.dto.CoachDTO;
import com.management.org.student_coach_management.Student.dto.StudentDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coaches")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }


    @PostMapping
    public ResponseEntity<CoachDTO> createCoach(@Valid @RequestBody CoachDTO coachDTO) {
        return new ResponseEntity<>(coachService.createCoach(coachDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CoachDTO>> getCoaches(@RequestParam(required = false, defaultValue = "0") int pageNo,
                                                     @RequestParam(required = false, defaultValue = "5") int pageSize,
                                                     @RequestParam(required = false,defaultValue = "id") String sortBy,
                                                     @RequestParam(required = false,defaultValue = "asc") String sortDir) {

        Sort sort = Sort.by(sortDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        return ResponseEntity.ok(coachService.getCoaches(PageRequest.of(pageNo, pageSize,sort)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachDTO> getCoachById(@PathVariable int id) {
        return new ResponseEntity<>(coachService.getCoachById(id), HttpStatus.OK);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<CoachDTO> updateCoach(@PathVariable int id, @Valid @RequestBody CoachDTO coachDTO) {
        return new ResponseEntity<>(coachService.updateCoach(id, coachDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CoachDTO> deleteCoach(@PathVariable int id) {
        return new ResponseEntity<>(coachService.deleteCoach(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/enrolled-students")
    public ResponseEntity<List<StudentDTO>> getEnrolledStudents(@RequestParam(required = false, defaultValue = "0") int pageNo,
                                                                @RequestParam(required = false, defaultValue = "5") int pageSize,
                                                                @PathVariable int id) {
        return new ResponseEntity<>(coachService.getEnrolledStudents(PageRequest.of(pageNo, pageSize), id), HttpStatus.OK);
    }
}
