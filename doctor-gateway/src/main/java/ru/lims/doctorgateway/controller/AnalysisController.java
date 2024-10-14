package ru.lims.doctorgateway.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.lims.doctorgateway.service.AnalysisService;

@RestController
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;


    @Operation(summary = "Создать новый анализ для теста с ID testId",
        description = "Создаёт на микросервисе, отвечающем за исследования заготовку для нового анализа")
    @ApiResponse(responseCode = "200", description = "Анализ успешно создан")
    @PostMapping("/analysis")
    public ResponseEntity<Long> create(@RequestParam("testId") Long testId, @RequestParam("patientId") Long patientId) {
        Long analysisId = analysisService.create(testId, patientId);
        return ResponseEntity.ok(analysisId);
    }
}