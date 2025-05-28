package com.example.courseRegistration.demo.controller;

import com.example.courseRegistration.demo.dto.Course;
import com.example.courseRegistration.demo.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/course")
@CrossOrigin(originPatterns = "*")
public class CourseController {
    private final ICourseService CourseService;

    @PostMapping()
    private ResponseEntity<Course> createCourse(@RequestBody Course course){
        Course course1 = CourseService.createCourse(course);
        return ResponseEntity.ok(course1);
    }

    @PutMapping("/{course_id}")
    private ResponseEntity<Course> updateCourse(@PathVariable(name = "course_id") Long courseId, @RequestBody Course course){
        Course course1 = CourseService.updateCourse(courseId,course);
        return ResponseEntity.ok(course1);
    }

    @GetMapping("/{course_id}")
    private ResponseEntity<Course> getCourse(@PathVariable(name = "course_id") Long courseId){
        Course course1 = CourseService.getCourse(courseId);
        return ResponseEntity.ok(course1);
    }

    @GetMapping()
    private ResponseEntity<List<Course>> getCourses(){
        List<Course> courses = CourseService.getCourses();
        return ResponseEntity.ok(courses);
    }

    @DeleteMapping("/{course_id}")
    private ResponseEntity<Map<String, String>> deleteCourse(@PathVariable(name = "course_id") Long courseId){
        CourseService.deleteCourse(courseId);
        return ResponseEntity.ok(Collections.singletonMap("message","deleted successfully"));
    }
}
