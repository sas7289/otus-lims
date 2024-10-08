package ru.lims.patients.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lims.patients.dto.ConsultationUpdateDto;
import ru.lims.patients.exception.ObjectNotFoundException;
import ru.lims.patients.mapper.ConsultationMapper;
import ru.lims.patients.model.Consultation;
import ru.lims.patients.model.MedicalHistory;
import ru.lims.patients.repository.ConsultationRepository;
import ru.lims.patients.repository.MedicalHistoryRepository;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    private ConsultationMapper consultationMapper;

    public long createConsultation(Long medicalHistoryId) {
        Consultation consultation = new Consultation();
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(medicalHistoryId)
            .orElseThrow(() -> new ObjectNotFoundException("MedicalHistory not found by ID: " + medicalHistoryId));
        consultation.setMedicalHistory(medicalHistory);
        Consultation savedConsultation = consultationRepository.save(consultation);
        return savedConsultation.getId();
    }

    public void update(ConsultationUpdateDto consultationUpdateDto) {
        Consultation consultation = consultationMapper.fromDto(consultationUpdateDto);

        MedicalHistory medicalHistory = medicalHistoryRepository.findById(consultationUpdateDto.getMedicalHistoryId())
            .orElseThrow(() -> new ObjectNotFoundException("MedicalHistory not found by ID: " + consultationUpdateDto.getMedicalHistoryId()));

        consultation.setMedicalHistory(medicalHistory);
        consultationRepository.save(consultation);
    }
}
