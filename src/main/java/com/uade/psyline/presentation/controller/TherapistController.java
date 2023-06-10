package com.uade.psyline.presentation.controller;

import com.uade.psyline.application.service.TherapistService;
import com.uade.psyline.presentation.dto.TherapistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/therapist")
public class TherapistController {

    @Autowired
    TherapistService therapistService;

    @PostMapping
    public ResponseEntity<TherapistDTO> postTherapist(@RequestBody TherapistDTO newTherapistDTO) {
        return new ResponseEntity<>(therapistService.postTherapist(newTherapistDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{userName}")
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


}
