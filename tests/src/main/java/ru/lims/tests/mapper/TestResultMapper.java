package ru.lims.tests.mapper;

import org.mapstruct.Mapper;
import ru.lims.tests.dto.BiomaterialDto;
import ru.lims.tests.dto.TestResultDto;
import ru.lims.tests.model.Biomaterial;
import ru.lims.tests.model.TestResult;

@Mapper(componentModel = "spring")
public interface TestResultMapper {

    TestResultDto toDto(TestResult testResult);
}
