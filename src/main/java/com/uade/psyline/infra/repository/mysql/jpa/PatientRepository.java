package com.uade.psyline.infra.repository.mysql.jpa;

import com.uade.psyline.infra.repository.mysql.dao.PatientDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientDAO, String> {

    PatientDAO findPatientByUserName(String userName);
}
