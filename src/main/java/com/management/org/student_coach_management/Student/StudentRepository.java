package com.management.org.student_coach_management.Student;

import com.management.org.student_coach_management.Student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
