package ru.lims.tests.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lims.tests.dto.AnalysisDto;
import ru.lims.tests.service.AnalysisService;

@Controller
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @Operation(summary = "Получить информацию об анализацх пациента по его ID",
        description = "Возвращает информацю об анализацх пациента по его ID")
    @ApiResponse(responseCode = "200",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = AnalysisDto.class)))
    @GetMapping("/analysis/patient/{patientId}")
    public ResponseEntity<List<AnalysisDto>> getAnalysisByPatientId(@PathVariable long patientId) {
        List<AnalysisDto> analysis = analysisService.getAnalysis(patientId);
        return ResponseEntity.ok(analysis);
    }

    @Operation(summary = "Создать новый анализ",
        description = "Возвращает ID нового анализа")
    @ApiResponse(responseCode = "200",
        description = "Анализ успешно создан",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class)))
    @PostMapping("/analysis")
    public ResponseEntity<Long> create(@RequestParam("testId") Long testId) {
        Long analysisId = analysisService.create(testId);
        return ResponseEntity.ok(analysisId);
    }

    @Operation(summary = "Обновить список анализов",
        description = "Обновляет список анализов")
    @ApiResponse(responseCode = "200",
        description = "Анализы успешно обновлены")
    @PutMapping("/analysis")
    public ResponseEntity<Void> update(@RequestBody List<AnalysisDto> analyzes) {
        analysisService.update(analyzes);
        return ResponseEntity.ok().build();
    }

}
