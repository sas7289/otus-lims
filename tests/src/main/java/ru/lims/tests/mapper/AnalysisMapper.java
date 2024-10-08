package ru.lims.tests.mapper;

import org.mapstruct.Mapper;
import ru.lims.tests.dto.AnalysisDto;
import ru.lims.tests.model.Analysis;

@Mapper(componentModel = "spring", uses = {TestMapper.class, BiomaterialMapper.class, TestResultMapper.class})
public interface AnalysisMapper {

    AnalysisDto toDto(Analysis analysis);

    Analysis fromDto(AnalysisDto analysisDto);
}
