package ru.lims.patients.mapper;

import org.mapstruct.Mapper;
import ru.lims.patients.dto.MedicalHistoryDto;
import ru.lims.patients.model.MedicalHistory;

@Mapper(componentModel = "spring", uses = ConsultationMapper.class)
public interface MedicalHistoryMapper {

    MedicalHistoryDto toDto(MedicalHistory medicalHistory);
}
