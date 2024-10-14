package ru.lims.tests.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lims.tests.dto.AnalysisDto;
import ru.lims.tests.exception.ObjectNotFoundException;
import ru.lims.tests.mapper.AnalysisMapper;
import ru.lims.tests.model.Analysis;
import ru.lims.tests.model.Test;
import ru.lims.tests.repository.AnalysisRepository;
import ru.lims.tests.repository.TestRepository;

@Service
public class AnalysisService {

    @Autowired
    private AnalysisMapper analysisMapper;

    @Autowired
    private AnalysisRepository analysisRepository;

    @Autowired
    private TestRepository testRepository;

    public List<AnalysisDto> getAnalysis(long patientId) {
        return analysisRepository.findAllByPatientId(patientId).stream()
            .map(analysisMapper::toDto)
            .toList();
    }

    public Long create(Long testId, Long patientId) {
        Test test = testRepository.findById(testId)
            .orElseThrow(() -> new ObjectNotFoundException("Test not found by ID: " + testId));
        Analysis analysis = new Analysis();
        analysis.setTest(test);
        analysis.setPatientId(patientId);
        Analysis savedAnalysis = analysisRepository.save(analysis);
        return savedAnalysis.getId();
    }

    public void update(List<AnalysisDto> analyzes) {
        analyzes.stream()
            .map(analysisMapper::fromDto)
            .forEach(this::update);
    }

    private void update(Analysis analysis) {
        analysisRepository.save(analysis);
    }
}
