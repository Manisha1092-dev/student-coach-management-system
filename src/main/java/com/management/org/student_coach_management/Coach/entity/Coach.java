package com.management.org.student_coach_management.Coach.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.management.org.student_coach_management.Student.entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "coach")
@Data
@NoArgsConstructor       // generates empty constructor
@AllArgsConstructor      // generates constructor with all fields
@Builder                 // generates builder() method
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "experience_years")
    private int experience;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "coach" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Student> students;

}
