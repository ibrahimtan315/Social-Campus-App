package com.socialCampusApplication.demo.client.dto.response.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialCampusApplication.demo.model.enums.Department;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class BaseUserRequest {

    @NotBlank(message = "Name con not be empty")
    private String name;

    @Email(regexp = "^(.+)@(.+)$", message = "Email is not valid. Please follow the example: turkcell@mail.com")
    @NotBlank(message = "Email con not be null")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

}

// controllerde kontrolleri yapmak icin kullandigimiz katman