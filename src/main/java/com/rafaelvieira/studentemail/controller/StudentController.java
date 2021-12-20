package com.rafaelvieira.studentemail.controller;


import com.rafaelvieira.studentemail.dto.StudentRequestDTO;
import com.rafaelvieira.studentemail.dto.mapper.StudentMapper;
import com.rafaelvieira.studentemail.entity.Student;
import com.rafaelvieira.studentemail.repository.StudentRepository;
import com.rafaelvieira.studentemail.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Student> save(@Valid @RequestBody StudentRequestDTO studentRequestDto) {
        Student student = StudentMapper.fromDto(studentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.studentService.save(student));
    }

}
