package com.example.courseRegistration.demo.service.impl;

import com.example.courseRegistration.demo.dto.Course;
import com.example.courseRegistration.demo.entity.CourseEntity;
import com.example.courseRegistration.demo.repository.CourseRepository;
import com.example.courseRegistration.demo.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public Course createCourse(Course course) {
        CourseEntity map = modelMapper.map(course, CourseEntity.class);
        CourseEntity courseEntity = courseRepository.saveAndFlush(map);
        return modelMapper.map(courseEntity,Course.class);
    }

    @Override
    public Course updateCourse(Long courseId, Course course) {
        CourseEntity courseEntity1 = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("course not found"));
        modelMapper.map(course, courseEntity1);
        CourseEntity courseEntity = courseRepository.saveAndFlush(courseEntity1);
        return modelMapper.map(courseEntity,Course.class);
    }

    @Override
    public Course getCourse(Long courseId) {
        CourseEntity courseEntity = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("course not found"));
        return modelMapper.map(courseEntity, Course.class);
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll().stream().map(v -> modelMapper.map(v, Course.class)).toList();
    }

    @Override
    public void deleteCourse(Long courseId) {
        if(!courseRepository.existsById(courseId)){
            throw new RuntimeException("course not found");
        }
        courseRepository.deleteById(courseId);
    }
}
