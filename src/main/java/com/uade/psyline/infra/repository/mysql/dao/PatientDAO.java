package com.uade.psyline.infra.repository.mysql.dao;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="patients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "patient")
    private Set<AppointmentDAO> appointments;

    @OneToMany(mappedBy = "patient")
    private Set<FollowUpDAO> followUps;

    @OneToMany(mappedBy = "patient")
    private Set<JournalEntryDAO> journal;
}
