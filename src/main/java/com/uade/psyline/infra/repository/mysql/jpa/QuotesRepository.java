package com.uade.psyline.infra.repository.mysql.jpa;

import com.uade.psyline.infra.repository.mysql.dao.QuotesDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotesRepository extends JpaRepository<QuotesDAO, Integer> {
    QuotesDAO findQuoteById(Integer id);
}
