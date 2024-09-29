package ru.lims.tests.mapper;

import org.mapstruct.Mapper;
import ru.lims.tests.dto.TestDto;
import ru.lims.tests.model.Test;

@Mapper(componentModel = "spring")
public interface TestMapper {

    TestDto toDto(Test test);
}
