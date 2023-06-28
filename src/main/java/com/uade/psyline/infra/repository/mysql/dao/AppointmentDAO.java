package com.uade.psyline.infra.repository.mysql.dao;

import com.uade.psyline.domain.appointment.Status;
import com.uade.psyline.domain.appointment.Type;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AppointmentDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")//capaz la T no va hay que probar esto
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

    @Column(nullable = true)
    private String invoice;

    @ManyToOne
    private TherapistDAO therapist;

    @ManyToOne
    private PatientDAO patient;
}
