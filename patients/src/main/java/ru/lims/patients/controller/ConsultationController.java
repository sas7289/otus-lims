package ru.lims.patients.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lims.patients.dto.ConsultationUpdateDto;
import ru.lims.patients.service.ConsultationService;

@Controller()
public class ConsultationController {

    @Autowired
    private ConsultationService patientService;

    @PostMapping("/consultation")
    public ResponseEntity<Long> create(@RequestParam(name = "medicalHistoryId") Long medicalHistoryId) {
        long consultationId = patientService.createConsultation(medicalHistoryId);
        return ResponseEntity.ok(consultationId);
    }

    @PutMapping("/consultation")
    public ResponseEntity<Void> update(@RequestBody ConsultationUpdateDto consultationUpdateDto) {
        patientService.update(consultationUpdateDto);
        return ResponseEntity.ok().build();
    }
}