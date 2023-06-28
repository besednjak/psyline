package com.uade.psyline.infra.repository.mysql.jpa;

import com.uade.psyline.domain.address.CABANeighborhood;
import com.uade.psyline.domain.therapist.AppointmentModality;
import com.uade.psyline.domain.therapist.Specialty;
import com.uade.psyline.domain.therapist.TherapyTreatment;
import com.uade.psyline.infra.repository.mysql.dao.TherapistDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface TherapistRepository extends JpaRepository<TherapistDAO, String> {
    TherapistDAO findTherapistByUserName(String username);

    @Query("SELECT t FROM TherapistDAO t WHERE " +
            "(:modality IS NULL OR t.appointmentModality = :modality) " +
            "AND (:specialty IS NULL OR t.specialty = :specialty) " +
            "AND (:practiceArea IS NULL OR t.practiceArea = :practiceArea) " +
            "AND (:minPrice IS NULL OR t.appointmentPrice >= :minPrice) " +
            "AND (:maxPrice IS NULL OR t.appointmentPrice <= :maxPrice)"+
            "AND (:therapyTreatments IS NULL OR :therapyTreatments MEMBER OF t.therapyTreatments)")
    List<TherapistDAO> findAllByFilters(AppointmentModality modality, Specialty specialty, CABANeighborhood practiceArea, Double minPrice, Double maxPrice, Set<TherapyTreatment> therapyTreatments);
}
