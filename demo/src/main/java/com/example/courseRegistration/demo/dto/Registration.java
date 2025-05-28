package com.example.courseRegistration.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Registration implements Serializable {

    private static final Long SerialVersionUid = 4862892L;

    private Long registrationId;

    private Long studentId;

    private List<Long> courseIds;

    private String registeredDate;


}
