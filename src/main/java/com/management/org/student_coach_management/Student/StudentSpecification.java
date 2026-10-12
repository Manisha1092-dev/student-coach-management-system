package com.management.org.student_coach_management.Student;

import com.management.org.student_coach_management.Student.entity.Student;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class StudentSpecification {


    public static Specification<Student> filterStudents(String firstName, String lastName, String major, String email) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (firstName != null && !firstName.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%"));
            }
            if (lastName != null && !lastName.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("lastName")), "%" + lastName.toLowerCase() + "%"));
            }
            if (major != null && !major.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("major")), "%" + major.toLowerCase() + "%"));
            }
            if (email != null && !email.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("email")), "%" + email.toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}
