package com.management.org.student_coach_management.Coach;

import com.management.org.student_coach_management.Coach.entity.Coach;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coaches")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Coach>> getCoaches() {
        return ResponseEntity.ok(coachService.getCoaches());
    }

}
