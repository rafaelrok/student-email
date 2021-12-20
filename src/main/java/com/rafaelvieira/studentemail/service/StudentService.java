package com.rafaelvieira.studentemail.service;


import com.rafaelvieira.studentemail.entity.Student;
import com.rafaelvieira.studentemail.mail.StudentMailComponent;
import com.rafaelvieira.studentemail.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;
    private StudentMailComponent studentMailComponent;

    public Student save(Student student) {
        this.studentRepository.save(student);
        this.studentMailComponent.sendWelcomeEmail(student);
        //this.studentMailComponent.sendSimpleWelcomeEmail(student);
        return student;
    }

}
