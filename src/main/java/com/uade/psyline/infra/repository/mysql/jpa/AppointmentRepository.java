package com.uade.psyline.infra.repository.mysql.jpa;

import com.uade.psyline.infra.repository.mysql.dao.AppointmentDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentDAO, Integer>{

    AppointmentDAO findAppointmentById(Integer id);
}
