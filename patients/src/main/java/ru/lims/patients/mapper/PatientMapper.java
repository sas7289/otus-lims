package ru.lims.patients.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.lims.patients.dto.PatientDto;
import ru.lims.patients.model.Patient;

@Mapper(uses = {MedicalHistoryMapper.class, ConsultationMapper.class})
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDto toDto(Patient patient);
}
