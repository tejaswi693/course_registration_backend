package com.example.courseRegistration.demo.controller;

import com.example.courseRegistration.demo.dto.Registration;
import com.example.courseRegistration.demo.service.impl.registrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/registration")
@CrossOrigin(originPatterns = "*")

public class RegistrationController {
    private final registrationService registrationService;


    @PostMapping("/registration")
    private ResponseEntity<Map<String, String>> studentCourseRegistration(@RequestBody Registration registration){
        registrationService.createRegistration(registration);
        return ResponseEntity.ok(Collections.singletonMap("message", "registration created successfully"));
    }

    @GetMapping("/getRegistrations")
    private ResponseEntity<List<Registration>> getRegistrationDetails(){

        List<Registration> registrations=  registrationService.getDetails();
        return ResponseEntity.ok(registrations);
    }
}
