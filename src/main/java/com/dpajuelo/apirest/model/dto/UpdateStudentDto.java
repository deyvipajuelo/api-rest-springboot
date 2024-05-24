package com.dpajuelo.apirest.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateStudentDto {

    private String firstName;
    private String lastName;
    private String studentCode;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

}
