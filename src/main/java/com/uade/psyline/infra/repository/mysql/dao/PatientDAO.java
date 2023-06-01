package com.uade.psyline.infra.repository.mysql.dao;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="patients")
public class PatientDAO {

    @Id
    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "patient")
    private Set<FollowUpDAO> appointments;

    @OneToMany(mappedBy = "patient")
    private Set<FollowUpDAO> followUps;
}
