package com.management.org.student_coach_management.Student.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.management.org.student_coach_management.Coach.entity.Coach;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="enrollment_date")
    private Date enrollmentDate;

    @Column(name="major")
    private String major;

    @Column(name="coach_id")
    private int coachId;

    @ManyToOne
    @JoinColumn(name = "coach_id", insertable = false, updatable = false)
    @JsonBackReference
    private Coach coach;

}
