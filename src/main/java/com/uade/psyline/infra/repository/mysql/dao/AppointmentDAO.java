package com.uade.psyline.infra.repository.mysql.dao;

import com.uade.psyline.domain.appointment.Status;
import com.uade.psyline.domain.appointment.Type;
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

    @Column(nullable = false)
    private boolean paid;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    private TherapistDAO therapist;

    @ManyToOne
    private PatientDAO patient;
}
