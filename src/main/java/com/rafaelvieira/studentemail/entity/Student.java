package com.rafaelvieira.studentemail.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private LocalDate birthday;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

}
