package ru.lims.doctorgateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lims.doctorgateway.service.AnalysisService;

@Controller
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @PostMapping("/analysis")
    public ResponseEntity<Long> create(@RequestParam("testId") Long testId) {
        Long analysisId = analysisService.create(testId);
        return ResponseEntity.ok(analysisId);
    }
}