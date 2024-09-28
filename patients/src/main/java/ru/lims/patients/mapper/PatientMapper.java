package ru.lims.patients.mapper;

import org.mapstruct.Mapper;
import ru.lims.patients.dto.PatientDto;
import ru.lims.patients.model.Patient;

@Mapper(componentModel = "spring", uses = {MedicalHistoryMapper.class, ConsultationMapper.class})
public interface PatientMapper {

    PatientDto toDto(Patient patient);
}
