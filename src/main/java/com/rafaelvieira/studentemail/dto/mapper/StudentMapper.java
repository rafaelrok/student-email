package com.rafaelvieira.studentemail.dto.mapper;


import com.rafaelvieira.studentemail.dto.StudentRequestDTO;
import com.rafaelvieira.studentemail.entity.Student;

public class StudentMapper {

    public static Student fromDto(StudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setPassword(dto.getPassword());
        student.setBirthday(dto.getBirthday());

        return student;
    }

}

