package com.uade.psyline.presentation.controller;

import com.uade.psyline.application.service.QuotesService;
import com.uade.psyline.presentation.dto.QuotesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/quotes")
public class QuotesController{
    @Autowired
    QuotesService quotesService;

    @GetMapping("/{quoteId}")
    public ResponseEntity<QuotesDTO> getQuote(@PathVariable Integer quoteId) {
        return new ResponseEntity<>(quotesService.getQuote(quoteId), HttpStatus.OK);
    }
}
