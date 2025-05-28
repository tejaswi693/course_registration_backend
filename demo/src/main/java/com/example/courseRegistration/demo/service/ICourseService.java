package com.example.courseRegistration.demo.service;

import com.example.courseRegistration.demo.dto.Course;

import java.util.List;

public interface ICourseService {
    Course createCourse(Course course);

    Course updateCourse(Long courseId, Course course);

    Course getCourse(Long courseId);

    List<Course> getCourses();

    void deleteCourse(Long courseId);
}
