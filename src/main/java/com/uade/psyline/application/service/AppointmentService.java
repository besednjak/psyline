package com.uade.psyline.application.service;

import com.uade.psyline.presentation.dto.JournalEntryDTO;
import com.uade.psyline.presentation.dto.AppointmentDTO;

public interface AppointmentService {

    AppointmentDTO postAppointment(AppointmentDTO newAppointment);

    AppointmentDTO getAppointment(Integer appointmentId);

    AppointmentDTO updateAppointment(AppointmentDTO updatedAppointmentDTO);

    AppointmentDTO deleteAppointment(Integer appointmentId);
}
