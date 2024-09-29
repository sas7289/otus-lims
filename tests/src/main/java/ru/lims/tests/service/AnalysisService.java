package ru.lims.tests.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lims.tests.dto.AnalysisDto;
import ru.lims.tests.mapper.AnalysisMapper;
import ru.lims.tests.repository.AnalysisRepository;

@Service
public class AnalysisService {

    @Autowired
    private AnalysisMapper analysisMapper;

    @Autowired
    private AnalysisRepository analysisRepository;

    public List<AnalysisDto> getAnalysis(long patientId) {
        return analysisRepository.findAllByPatientId(patientId).stream()
            .map(analysisMapper::toDto)
            .toList();
    }

}
