package com.uade.psyline.infra.repository.mysql.jpa;

import com.uade.psyline.infra.repository.mysql.dao.WorkingTimeDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTimeRepository extends JpaRepository<WorkingTimeDAO, Integer> {

    WorkingTimeDAO findWorkingTimeById(Integer id);
}
