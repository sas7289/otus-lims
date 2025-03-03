package ru.lims.patients.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lims.patients.dto.PatientDto;
import ru.lims.patients.exception.ObjectNotFoundException;
import ru.lims.patients.mapper.PatientMapper;
import ru.lims.patients.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;


    @Transactional
    public PatientDto findById(long id) {
        return patientRepository.findById(id)
            .map(patientMapper::toDto)
            .orElseThrow(() -> new ObjectNotFoundException("Patient not found by ID: " + id));
    }
}
