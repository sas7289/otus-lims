package ru.lims.patients.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.lims.patients.dto.ConsultationUpdateDto;
import ru.lims.patients.service.ConsultationService;

@RestController
public class ConsultationController {

    @Autowired
    private ConsultationService patientService;

    @Operation(summary = "Создать новую консультацию",
        description = "Возвращает ID новой консультации")
    @ApiResponse(responseCode = "200",
        description = "Консультация успешно создана",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class)))
    @PostMapping("/consultation")
    public ResponseEntity<Long> create(@RequestParam(name = "medicalHistoryId") Long medicalHistoryId) {
        long consultationId = patientService.createConsultation(medicalHistoryId);
        return ResponseEntity.ok(consultationId);
    }

    @Operation(summary = "Обновить консультацию",
        description = "Обновляет консультацию")
    @ApiResponse(responseCode = "200",
        description = "Консультация успешно обновлена")
    @PutMapping("/consultation")
    public ResponseEntity<Void> update(@RequestBody ConsultationUpdateDto consultationUpdateDto) {
        patientService.update(consultationUpdateDto);
        return ResponseEntity.ok().build();
    }
}