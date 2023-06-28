package com.uade.psyline.infra.repository.mysql.dao;

import com.uade.psyline.domain.address.CABANeighborhood;
import com.uade.psyline.domain.therapist.AppointmentModality;
import com.uade.psyline.domain.therapist.Specialty;
import com.uade.psyline.domain.therapist.TherapyTreatment;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="therapists")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TherapistDAO {

    @Id
    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(nullable = false)
    private String licence;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AppointmentModality appointmentModality;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CABANeighborhood practiceArea;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String bio;

    @Column(nullable = false)
    private Double appointmentPrice;

    @Column(nullable = true)
    private String picture;

    @OneToMany(mappedBy = "therapist")
    private Set<AppointmentDAO> appointments;

    @OneToMany(mappedBy = "therapist")
    private Set<FollowUpDAO> followUps;

    @Column(nullable=true)
    @OneToMany(mappedBy = "therapyTreatment")
    private Set<TherapyTreatmentDAO> therapyTreatments;

    @OneToMany(mappedBy = "therapist")
    private Set<WorkingTimeDAO> workingSchedule;

}
