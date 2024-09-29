package ru.lims.tests.mapper;

import org.mapstruct.Mapper;
import ru.lims.tests.dto.BiomaterialDto;
import ru.lims.tests.dto.TestDto;
import ru.lims.tests.model.Biomaterial;
import ru.lims.tests.model.Test;

@Mapper(componentModel = "spring")
public interface BiomaterialMapper {

    BiomaterialDto toDto(Biomaterial biomaterial);
}
