package com.rafaelvieira.studentemail.repository;

import com.rafaelvieira.studentemail.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}

