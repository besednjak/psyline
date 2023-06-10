package com.uade.psyline.infra.repository.mysql.jpa;

import com.uade.psyline.infra.repository.mysql.dao.TherapistDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TherapistRepository extends JpaRepository<TherapistDAO, String> {
    TherapistDAO findTherapistByUserName(String username);
}
