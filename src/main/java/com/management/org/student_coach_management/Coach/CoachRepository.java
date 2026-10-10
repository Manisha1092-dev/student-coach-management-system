package com.management.org.student_coach_management.Coach;

import com.management.org.student_coach_management.Coach.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * Repository for Coach entities. Inherits CRUD and paging/sorting behavior from JpaRepository.
 */
public interface CoachRepository extends JpaRepository<Coach, Long> {

}
