package com.uade.psyline.presentation.controller;

import com.uade.psyline.application.service.AppointmentService;
import com.uade.psyline.presentation.dto.AppointmentDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> postAppointment(@RequestBody AppointmentDTO newAppointmentDTO) {
        return new ResponseEntity<>(appointmentService.postAppointment(newAppointmentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable Integer appointmentId) {
        return new ResponseEntity<>(appointmentService.getAppointment(appointmentId), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody AppointmentDTO updatedAppointmentDTO) {
        return new ResponseEntity<>(appointmentService.updateAppointment(updatedAppointmentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDTO> deleteAppointment(@PathVariable Integer appointmentId) {
        return new ResponseEntity<>(appointmentService.deleteAppointment(appointmentId), HttpStatus.OK);
    }

    @GetMapping("/therapist/{therapistUserName}")
    @Transactional
    public ResponseEntity<List<AppointmentDTO>> getTherapistAppointments(@PathVariable String therapistUserName) {
        return new ResponseEntity<>(appointmentService.getTherapistAppointments(therapistUserName), HttpStatus.OK);
    }
}
