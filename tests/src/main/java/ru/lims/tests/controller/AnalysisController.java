package ru.lims.tests.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.lims.tests.dto.AnalysisDto;
import ru.lims.tests.service.AnalysisService;

@Controller
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @GetMapping("analysis/patient/{patientId}")
    public ResponseEntity<List<AnalysisDto>> getAnalysisByPatientId(@PathVariable long patientId) {
        List<AnalysisDto> analysis = analysisService.getAnalysis(patientId);
        return ResponseEntity.ok(analysis);
    }

}
