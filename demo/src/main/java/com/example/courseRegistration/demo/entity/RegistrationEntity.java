package com.example.courseRegistration.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "registration")
@Getter
@Setter
@Entity
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @Column(name = "student_id", length = 100)
    private Long studentId;

    @Column(name = "course_ids", length = 50)
    private List<Long> courseIds;

    @Column(name = "registered_date", length = 50)
    private String registeredDate;
}
