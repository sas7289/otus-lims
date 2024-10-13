package ru.lims.patients.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.lims.patients.dto.PatientDto;
import ru.lims.patients.service.PatientService;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Operation(summary = "Получить информацию о пациенте",
        description = "Возвращает информацю о пациенте по его ID")
    @ApiResponse(responseCode = "200",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = PatientDto.class)))
    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") long id) {
        PatientDto patient = patientService.findById(id);
        return ResponseEntity.ok(patient);
    }
}