package ru.lims.patients.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.lims.patients.dto.PatientDto;
import ru.lims.patients.models.Patient;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDto toDto(Patient patient);
}
