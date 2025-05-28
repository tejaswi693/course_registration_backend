package com.example.courseRegistration.demo.service;

import com.example.courseRegistration.demo.dto.Registration;
import com.example.courseRegistration.demo.dto.Student;

import java.util.List;

public interface IStudentService {
    Student createstudent(Student student);

    Student updateStudent(Long studentId, Student student);

    Student getStudent(Long studentId);

    List<Student> getStudents();

    void deleteStudent(Long studentId);

}
