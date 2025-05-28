package com.example.courseRegistration.demo.service.impl;

import com.example.courseRegistration.demo.dto.Registration;
import com.example.courseRegistration.demo.dto.Student;
import com.example.courseRegistration.demo.entity.CourseEntity;
import com.example.courseRegistration.demo.entity.StudentEntity;
import com.example.courseRegistration.demo.repository.CourseRepository;
import com.example.courseRegistration.demo.repository.RegistrationRepository;
import com.example.courseRegistration.demo.repository.StudentRepository;
import com.example.courseRegistration.demo.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final RegistrationRepository registrationRepository;

    @Override
    public Student createstudent(Student student) {
        StudentEntity map = modelMapper.map(student, StudentEntity.class);
        StudentEntity studentEntity = studentRepository.saveAndFlush(map);
        return modelMapper.map(studentEntity,Student.class);
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {
        StudentEntity studentEntity1 = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("student not found"));
        modelMapper.map(student, studentEntity1);
        StudentEntity studentEntity = studentRepository.saveAndFlush(studentEntity1);
        return modelMapper.map(studentEntity,Student.class);
    }

    @Override
    public Student getStudent(Long studentId) {
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("student not found"));
        return modelMapper.map(studentEntity, Student.class);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll().stream().map(v -> modelMapper.map(v, Student.class)).toList();
    }

    @Override
    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)){
            throw new RuntimeException("student not found");
        }
        studentRepository.deleteById(studentId);
    }

}
