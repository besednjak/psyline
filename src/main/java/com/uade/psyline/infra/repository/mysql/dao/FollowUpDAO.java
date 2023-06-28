package com.uade.psyline.infra.repository.mysql.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "follow_ups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FollowUpDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private TherapistDAO therapist;

    @ManyToOne
    private PatientDAO patient;
}
