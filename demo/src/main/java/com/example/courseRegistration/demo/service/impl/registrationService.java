package com.example.courseRegistration.demo.service.impl;

import com.example.courseRegistration.demo.dto.Registration;
import com.example.courseRegistration.demo.entity.CourseEntity;
import com.example.courseRegistration.demo.entity.RegistrationEntity;
import com.example.courseRegistration.demo.entity.StudentEntity;
import com.example.courseRegistration.demo.repository.CourseRepository;
import com.example.courseRegistration.demo.repository.RegistrationRepository;
import com.example.courseRegistration.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class registrationService {
    private final RegistrationRepository registerRepository;
    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public void createRegistration(Registration registration) {
        StudentEntity studentEntity = studentRepository.findById(registration.getStudentId()).orElseThrow(() -> new RuntimeException("student not found"));
        List<CourseEntity> allById = courseRepository.findAllById(registration.getCourseIds());
        studentEntity.setCourses(new HashSet<>(allById));
        studentRepository.saveAndFlush(studentEntity);
    }


    public List<Registration> getDetails() {
        return registerRepository.findAll().stream().map(v -> modelMapper.map(v, Registration.class)).toList();
    }

    public Registration updateRegister(Long registerId, Registration register) {
        RegistrationEntity registerEntity1 = registerRepository.findById(registerId).orElseThrow(() -> new RuntimeException("register not found"));
        modelMapper.map(register, registerEntity1);
        RegistrationEntity registerEntity = registerRepository.saveAndFlush(registerEntity1);
        return modelMapper.map(registerEntity, Registration.class);
    }


    public Registration getRegister(Long registerId) {
        RegistrationEntity registerEntity = registerRepository.findById(registerId).orElseThrow(() -> new RuntimeException("register not found"));
        return modelMapper.map(registerEntity, Registration.class);
    }


    public List<Registration> getRegisters() {
        return registerRepository.findAll().stream().map(v -> modelMapper.map(v, Registration.class)).toList();
    }


    public void deleteRegister(Long registerId) {
        if (!registerRepository.existsById(registerId)) {
            throw new RuntimeException("register not found");
        }
        registerRepository.deleteById(registerId);
    }
}
