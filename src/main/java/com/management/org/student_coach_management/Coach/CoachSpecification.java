package com.management.org.student_coach_management.Coach;

import com.management.org.student_coach_management.Coach.entity.Coach;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class CoachSpecification {

    public static Specification<Coach> searchAllFields(String searchText) {
        return (root, query, cb) -> {
            if (searchText == null || searchText.isEmpty()) {
                return cb.conjunction(); // no filtering, return all coaches
            }



            String likePattern = "%" + searchText.toLowerCase() + "%";

            Predicate firstNameMatch = cb.like(cb.lower(root.get("firstName")), likePattern);
            Predicate lastNameMatch = cb.like(cb.lower(root.get("lastName")), likePattern);
            Predicate specialtyMatch = cb.like(cb.lower(root.get("specialty")), likePattern);
            Predicate emailMatch = cb.like(cb.lower(root.get("email")), likePattern);

            Predicate experienceMatch;
            if (searchText.matches("\\d+")) {
                // numeric comparison
                int years = Integer.parseInt(searchText);
                experienceMatch = cb.equal(root.get("experience"), years);
            } else {
                // fallback: treat as string
                experienceMatch = cb.like(
                        cb.function("CAST", String.class, root.get("experience")),
                        "%" + searchText + "%"
                );
            }

            // Combine with OR → match if searchText appears in ANY field
            return cb.or(firstNameMatch, lastNameMatch, specialtyMatch, emailMatch, experienceMatch);
        };
    }

}
