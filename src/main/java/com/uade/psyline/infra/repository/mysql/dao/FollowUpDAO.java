package com.uade.psyline.infra.repository.mysql.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "follow_ups")
public class FollowUpDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private TherapistDAO therapist;

    @ManyToOne
    private PatientDAO patient;
}
