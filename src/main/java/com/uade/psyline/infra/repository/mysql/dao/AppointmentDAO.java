package com.uade.psyline.infra.repository.mysql.dao;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class AppointmentDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-ddTHH:mm:ssZ")//capaz la T no va hay que probar esto
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    private TherapistDAO therapist;

    @ManyToOne
    private PatientDAO patient;
}
