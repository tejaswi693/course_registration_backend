package com.example.courseRegistration.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private Set<StudentEntity> students = new HashSet<>();

}
