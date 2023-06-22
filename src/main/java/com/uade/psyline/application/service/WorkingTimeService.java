package com.uade.psyline.application.service;

import com.uade.psyline.presentation.dto.WorkingTimeDTO;

import java.util.List;

public interface WorkingTimeService {

    WorkingTimeDTO postWorkingTime(WorkingTimeDTO newWorkingTime);

    WorkingTimeDTO getWorkingTime(Integer workingTimeId);

    WorkingTimeDTO updateWorkingTime(WorkingTimeDTO updatedWorkingTimeDTO);

    WorkingTimeDTO deleteWorkingTime(Integer workingTimeId);

    List<WorkingTimeDTO> getTherapistSchedule(String therapistUserName);
}
