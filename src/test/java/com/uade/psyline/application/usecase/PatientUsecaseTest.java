package com.uade.psyline.application.usecase;

import com.uade.psyline.infra.repository.mysql.jpa.PatientRepository;
import com.uade.psyline.presentation.dto.PatientDTO;
import com.uade.psyline.infra.repository.mysql.dao.PatientDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PatientUsecaseTest {

    PatientUsecase patientUsecase;
    PatientRepository patientRepository;
    ModelMapper mapper;

    @BeforeEach
    void setUp() {
        patientUsecase = new PatientUsecase();
        patientRepository = mock(PatientRepository.class);
        mapper = mock(ModelMapper.class);
        ReflectionTestUtils.setField(patientUsecase, "patientRepository", patientRepository);
        ReflectionTestUtils.setField(patientUsecase, "mapper", mapper);
    }

    @Test
    void postPatient() {
        //Arrange
        PatientDTO expectedPatientDTO = this.getExpectedPatientDTO();
        PatientDTO actualPatientDTO;
        PatientDAO patientDAO = this.getPatientDAO();
        when(mapper.map(expectedPatientDTO, PatientDAO.class)).thenReturn(patientDAO);
        when(mapper.map(patientDAO, PatientDTO.class)).thenReturn(expectedPatientDTO);

        //Act
        actualPatientDTO = patientUsecase.postPatient(expectedPatientDTO);

        //Assert
        verify(mapper).map(expectedPatientDTO, PatientDAO.class);
        verify(patientRepository).save(patientDAO);
        verify(mapper).map(patientDAO, PatientDTO.class);
        assertEquals(expectedPatientDTO, actualPatientDTO);
    }

    @Test
    void getPatient() {
        //Arrange
        String userName = "pJuanetes";
        PatientDTO expectedPatientDTO = this.getExpectedPatientDTO();
        PatientDTO actualPatientDTO;
        PatientDAO patientDAO = this.getPatientDAO();
        when(patientRepository.findPatientByUserName(userName)).thenReturn(patientDAO);
        when(mapper.map(patientDAO, PatientDTO.class)).thenReturn(expectedPatientDTO);

        //Act
        actualPatientDTO = patientUsecase.getPatient(userName);

        //Assert
        verify(patientRepository).findPatientByUserName(userName);
        verify(mapper).map(patientDAO, PatientDTO.class);
        assertEquals(expectedPatientDTO, actualPatientDTO);
    }

    @Test
    void updatePatient() {
        //Arrange
        PatientDTO expectedPatientDTO = this.getExpectedPatientDTO();
        PatientDTO actualPatientDTO;
        PatientDAO patientDAO = this.getPatientDAO();
        when(patientRepository.findPatientByUserName(expectedPatientDTO.getUserName())).thenReturn(patientDAO);
        when(mapper.map(expectedPatientDTO, PatientDAO.class)).thenReturn(patientDAO);
        when(mapper.map(patientDAO, PatientDTO.class)).thenReturn(expectedPatientDTO);

        //Act
        actualPatientDTO = patientUsecase.updatePatient(expectedPatientDTO);

        //Assert
        verify(patientRepository).findPatientByUserName(expectedPatientDTO.getUserName());
        verify(mapper).map(expectedPatientDTO, PatientDAO.class);
        verify(patientRepository).save(patientDAO);
        verify(mapper).map(patientDAO, PatientDTO.class);
        assertEquals(expectedPatientDTO, actualPatientDTO);

    }

    @Test
    void deletePatient() {
        //Arrange
        String userName = "pJuanetes";
        PatientDTO expectedPatientDTO = this.getExpectedPatientDTO();
        PatientDTO actualPatientDTO;
        PatientDAO patientDAO = this.getPatientDAO();
        when(patientRepository.findPatientByUserName(userName)).thenReturn(patientDAO);
        when(mapper.map(patientDAO, PatientDTO.class)).thenReturn(expectedPatientDTO);

        //Act
        actualPatientDTO = patientUsecase.deletePatient(userName);

        //Assert
        verify(patientRepository).findPatientByUserName(userName);
        verify(patientRepository).delete(patientDAO);
        verify(mapper).map(patientDAO, PatientDTO.class);
        assertEquals(expectedPatientDTO, actualPatientDTO);
    }

    // ------------------------------( UTIL )------------------------------//.
    private PatientDTO getExpectedPatientDTO() {
        return new PatientDTO(
                "pJuanetes",
                "Pepito",
                "Juanetes",
                LocalDate.of(1999, 12, 3),
                "pjuanetes@uade.edu.ar"
        );
    }

    private PatientDAO getPatientDAO() {
        return PatientDAO.builder()
                .userName("pJuanetes")
                .name("Pepito")
                .lastName("Juanetes")
                .birthDate(LocalDate.of(1999, 12, 3))
                .email("pjuanetes@uade.edu.ar")
                .build();
    }
}