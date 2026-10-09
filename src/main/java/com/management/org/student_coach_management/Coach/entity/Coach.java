package com.management.org.student_coach_management.Coach.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coach")
public class Coach {

    Coach() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "experience_years")
    private int experience;

    @Column(name = "email")
    private String email;

}
