package com.rafaelvieira.studentemail.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class StudentRequestDTO {

    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

}
