package com.management.org.student_coach_management.Coach;

import com.management.org.student_coach_management.Coach.dto.CoachDTO;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<CoachDTO>> getCoaches() {
        return ResponseEntity.ok(coachService.getCoaches());
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
}
