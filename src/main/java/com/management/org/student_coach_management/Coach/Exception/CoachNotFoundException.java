package com.management.org.student_coach_management.Coach.Exception;

/**
 * Runtime exception thrown when a requested Coach cannot be found in the system.
 */
public class CoachNotFoundException extends RuntimeException {

    public CoachNotFoundException(String s) {
        super(s);
    }


}
