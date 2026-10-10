package com.management.org.student_coach_management.Student.Exception;

/**
 * Runtime exception thrown when a requested Student cannot be found in the system.
 */
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String s) {
        super(s);
    }


}
