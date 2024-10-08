package ru.lims.tests.controller;

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

    @GetMapping("/analysis/patient/{patientId}")
    public ResponseEntity<List<AnalysisDto>> getAnalysisByPatientId(@PathVariable long patientId) {
        List<AnalysisDto> analysis = analysisService.getAnalysis(patientId);
        return ResponseEntity.ok(analysis);
    }

    @PostMapping("/analysis")
    public ResponseEntity<Long> create(@RequestParam("testId") Long testId) {
        Long analysisId = analysisService.create(testId);
        return ResponseEntity.ok(analysisId);
    }

    @PutMapping("/analysis")
    public ResponseEntity<Void> update(@RequestBody List<AnalysisDto> analyzes) {
        analysisService.update(analyzes);
        return ResponseEntity.ok().build();
    }

}
