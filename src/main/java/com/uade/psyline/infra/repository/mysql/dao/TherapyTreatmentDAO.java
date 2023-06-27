package com.uade.psyline.infra.repository.mysql.dao;

import com.uade.psyline.domain.therapist.TherapyTreatment;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="therapy_treatment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TherapyTreatmentDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TherapyTreatment therapyTreatment;
}
