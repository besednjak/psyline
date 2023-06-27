package com.uade.psyline.presentation.controller;

import com.uade.psyline.application.service.TherapistService;
import com.uade.psyline.domain.address.CABANeighborhood;
import com.uade.psyline.domain.therapist.AppointmentModality;
import com.uade.psyline.domain.therapist.Specialty;
import com.uade.psyline.domain.therapist.TherapyTreatment;
import com.uade.psyline.presentation.dto.TherapistDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/therapists")
public class TherapistController {

    @Autowired
    TherapistService therapistService;

    @PostMapping
    public ResponseEntity<TherapistDTO> postTherapist(@RequestBody TherapistDTO newTherapistDTO) {
        return new ResponseEntity<>(therapistService.postTherapist(newTherapistDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{userName}")
    @Transactional
    public ResponseEntity<TherapistDTO> getTherapist(@PathVariable String userName) {
        return new ResponseEntity<>(therapistService.getTherapist(userName), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<TherapistDTO> updateTherapist(@RequestBody TherapistDTO newTherapistDTO) {
        return new ResponseEntity<>(therapistService.updateTherapist(newTherapistDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<TherapistDTO> deleteTherapist(@PathVariable String userName) {
        return new ResponseEntity<>(therapistService.deleteTherapist(userName), HttpStatus.OK);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<TherapistDTO>> getTherapists(
            @RequestParam(required = false) AppointmentModality modality,
            @RequestParam(required = false) Specialty specialty,
            @RequestParam(required = false, name = "practice_area") CABANeighborhood practiceArea,
            @RequestParam(required = false, name = "min_price") Double minPrice,
            @RequestParam(required = false, name = "max_price") Double maxPrice,
            @RequestParam(required = false, name = "therapy_treatment") Set<String> therapyTreatments
            ) {
        return new ResponseEntity<>(
                therapistService.getTherapists(modality, specialty, practiceArea, minPrice, maxPrice, therapyTreatments),
                HttpStatus.OK
        );
    }
    
}
