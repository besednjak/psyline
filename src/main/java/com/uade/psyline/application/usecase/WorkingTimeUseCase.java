package com.uade.psyline.application.usecase;

import com.uade.psyline.application.exception.TherapistNotFoundException;
import com.uade.psyline.application.exception.WorkingTimeNotFoundException;
import com.uade.psyline.application.service.WorkingTimeService;
import com.uade.psyline.infra.repository.mysql.dao.TherapistDAO;
import com.uade.psyline.infra.repository.mysql.dao.WorkingTimeDAO;
import com.uade.psyline.infra.repository.mysql.jpa.TherapistRepository;
import com.uade.psyline.infra.repository.mysql.jpa.WorkingTimeRepository;
import com.uade.psyline.presentation.dto.TherapistDTO;
import com.uade.psyline.presentation.dto.WorkingTimeDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeUseCase implements WorkingTimeService {
    private final ModelMapper mapper = new ModelMapper();
    @Autowired
    private WorkingTimeRepository workingTimeRepository;
    @Autowired
    private TherapistRepository therapistRepository;

    @Override
    @Transactional
    public TherapistDTO postWorkingTime(WorkingTimeDTO newWorkingTimeDTO){
        TherapistDAO therapistDAO = findTherapistByUserName(newWorkingTimeDTO.getTherapistUserName());
        WorkingTimeDAO newWorkingTimeDAO = mapper.map(newWorkingTimeDTO, WorkingTimeDAO.class);
        newWorkingTimeDAO.setTherapist(therapistDAO);
        workingTimeRepository.save(newWorkingTimeDAO);

        return mapper.map(therapistDAO, TherapistDTO.class);
    }

    @Override
    public WorkingTimeDTO getWorkingTime(Integer workingTimeId){
        WorkingTimeDAO workingTimeFoundDAO = this.findWorkingTimeById(workingTimeId);
        return mapper.map(workingTimeFoundDAO, WorkingTimeDTO.class);
    }

    @Override
    @Transactional
    public WorkingTimeDTO updateWorkingTime(WorkingTimeDTO updatedWorkingTimeDTO) {
        WorkingTimeDAO existingWorkingTimeDAO = this.findWorkingTimeById(updatedWorkingTimeDTO.getId());
        WorkingTimeDAO updatedWorkingTimeDAO = mapper.map(updatedWorkingTimeDTO, WorkingTimeDAO.class);
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(updatedWorkingTimeDAO, existingWorkingTimeDAO);
        workingTimeRepository.save(existingWorkingTimeDAO);

        return mapper.map(existingWorkingTimeDAO, WorkingTimeDTO.class);
    }

    @Override
    public WorkingTimeDTO deleteWorkingTime(Integer workingTimeId){
        WorkingTimeDAO workingTimeFoundDAO = this.findWorkingTimeById(workingTimeId);
        workingTimeRepository.delete(workingTimeFoundDAO);
        return mapper.map(workingTimeFoundDAO, WorkingTimeDTO.class);
    }

    @Override
    public List<WorkingTimeDTO> getTherapistSchedule(String therapistUserName) {
        TherapistDAO therapistDAO = findTherapistByUserName(therapistUserName);

        return therapistDAO.getWorkingSchedule().stream()
                .map(WorkingTimeDAO -> mapper.map(WorkingTimeDAO, WorkingTimeDTO.class)).toList();
    }

    private WorkingTimeDAO findWorkingTimeById(Integer id) {
        WorkingTimeDAO workingTimeFoundDAO = workingTimeRepository.findWorkingTimeById(id);
        if(workingTimeFoundDAO == null) {
            throw new WorkingTimeNotFoundException();
        }
        return workingTimeFoundDAO;
    }

    private TherapistDAO findTherapistByUserName(String userName) {
        TherapistDAO therapistFoundDAO = therapistRepository.findTherapistByUserName(userName);
        if(therapistFoundDAO == null) {
            throw new TherapistNotFoundException();
        }
        return therapistFoundDAO;
    }
}
