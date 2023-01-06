package com.socialCampusApplication.demo.client.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialCampusApplication.demo.model.enums.Department;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class UserDto {

    private Long id;

    private String name;

    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty(value = "birth-date")
    private LocalDate birthDate;

    private Department department;



}

// direkt modeli disariya acmamak icin kullandigimiz katman