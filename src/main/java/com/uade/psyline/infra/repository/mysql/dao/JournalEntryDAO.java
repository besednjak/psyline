package com.uade.psyline.infra.repository.mysql.dao;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.uade.psyline.domain.patient.Emotion;

import java.time.LocalDate;

@Entity
@Table(name="journal_entry")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JournalEntryDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Emotion emotion;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private PatientDAO patient;
}
