package ru.lims.doctorgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lims.doctorgateway.dto.ConsultationUpdateDto;
import ru.lims.doctorgateway.service.ConsultationService;

@Controller
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @PostMapping("/consultation")
    public ResponseEntity<Long> create(@RequestParam(name = "medicalHistoryId") Long medicalHistoryId) {
        long consultationId = consultationService.create(medicalHistoryId);
        return ResponseEntity.ok(consultationId);
    }

    @PutMapping("/consultation")
    public ResponseEntity<Long> update(@RequestBody ConsultationUpdateDto consultationUpdateDto) {
        long consultationId = consultationService.update(consultationUpdateDto);
        return ResponseEntity.ok(consultationId);
    }

}
