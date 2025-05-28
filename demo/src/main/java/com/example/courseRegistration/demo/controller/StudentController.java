package com.example.courseRegistration.demo.controller;

import com.example.courseRegistration.demo.dto.Registration;
import com.example.courseRegistration.demo.dto.Student;
import com.example.courseRegistration.demo.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
@CrossOrigin(originPatterns = "*")
public class StudentController {

    private final IStudentService studentService;

    @PostMapping()
    private ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student student1 = studentService.createstudent(student);
        return ResponseEntity.ok(student1);
    }

    @PutMapping("/{student_id}")
    private ResponseEntity<Student> updateStudent(@PathVariable(name = "student_id") Long studentId, @RequestBody Student student){
        Student student1 = studentService.updateStudent(studentId, student);
        return ResponseEntity.ok(student1);
    }

    @GetMapping("/{student_id}")
    private ResponseEntity<Student> getStudent(@PathVariable(name = "student_id") Long studentId){
        Student student1 = studentService.getStudent(studentId);
        return ResponseEntity.ok(student1);
    }

    @GetMapping()
    private ResponseEntity<List<Student>> getStudents(){
        List<Student> students = studentService.getStudents();
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/{student_id}")
    private ResponseEntity<Map<String, String>> deleteStudent(@PathVariable(name = "student_id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok(Collections.singletonMap("message","deleted successfully"));
    }


}


