package com.uade.psyline.application.usecase;

import com.uade.psyline.application.service.QuotesService;
import com.uade.psyline.infra.repository.mysql.dao.QuotesDAO;
import com.uade.psyline.infra.repository.mysql.jpa.QuotesRepository;
import com.uade.psyline.presentation.dto.QuotesDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuotesUsecase implements QuotesService {
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    private QuotesRepository quotesRepository;

    @Override
    public QuotesDTO getQuote(Integer quoteId) {
        QuotesDAO quoteFoundDAO = quotesRepository.findQuoteById(quoteId);
        return mapper.map(quoteFoundDAO, QuotesDTO.class);
    }
}
