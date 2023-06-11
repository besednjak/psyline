package com.uade.psyline.infra.repository.mysql.jpa;

import com.uade.psyline.infra.repository.mysql.dao.JournalEntryDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepository extends JpaRepository<JournalEntryDAO, Integer> {

}
