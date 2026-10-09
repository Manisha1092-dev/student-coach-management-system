package com.management.org.student_coach_management.Coach;

import com.management.org.student_coach_management.Coach.entity.Coach;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    @Override
    public List<Coach> getCoaches() {
        // Implement the logic to retrieve coaches from the database or any other source
        return new ArrayList<>(); // Return an empty list for now
    }
}
