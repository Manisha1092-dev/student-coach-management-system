package com.management.org.student_coach_management.Student;

import com.management.org.student_coach_management.Student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Student entities. Extends JpaRepository to provide CRUD
 * operations along with paging and sorting support.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Page<Student> findByCoachId(Long coachId, Pageable pageable);
}
