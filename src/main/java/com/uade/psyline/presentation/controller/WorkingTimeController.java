package com.uade.psyline.presentation.controller;

import com.uade.psyline.application.service.WorkingTimeService;
import com.uade.psyline.presentation.dto.WorkingTimeDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workingTime")
public class WorkingTimeController {

    @Autowired
    WorkingTimeService workingTimeService;

    @PostMapping
    public ResponseEntity<WorkingTimeDTO> postWorkingTime(@RequestBody WorkingTimeDTO newWorkingTimeDTO) {
        return new ResponseEntity<>(workingTimeService.postWorkingTime(newWorkingTimeDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{workingTimeId}")
    public ResponseEntity<WorkingTimeDTO> getWorkingTime(@PathVariable Integer workingTimeId) {
        return new ResponseEntity<>(workingTimeService.getWorkingTime(workingTimeId), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<WorkingTimeDTO> updateWorkingTime(@RequestBody WorkingTimeDTO updatedWorkingTime) {
        return new ResponseEntity<>(workingTimeService.updateWorkingTime(updatedWorkingTime), HttpStatus.OK);
    }

    @DeleteMapping("/{workingTimeId}")
    public ResponseEntity<WorkingTimeDTO> deleteWorkingTime(@PathVariable Integer workingTimeId) {
        return new ResponseEntity<>(workingTimeService.deleteWorkingTime(workingTimeId), HttpStatus.OK);
    }

    @GetMapping("/therapist/{therapistUserName}")
    @Transactional
    public ResponseEntity<List<WorkingTimeDTO>> getTherapistSchedule(@PathVariable String therapistUserName) {
        return new ResponseEntity<>(workingTimeService.getTherapistSchedule(therapistUserName), HttpStatus.OK);
    }
}
