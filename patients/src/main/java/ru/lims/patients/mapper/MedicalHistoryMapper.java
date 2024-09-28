package ru.lims.patients.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.lims.patients.dto.MedicalHistoryDto;
import ru.lims.patients.model.MedicalHistory;

@Mapper(uses = ConsultationMapper.class)
public interface MedicalHistoryMapper {

    MedicalHistoryMapper INSTANCE = Mappers.getMapper(MedicalHistoryMapper.class);

    MedicalHistoryDto toDto(MedicalHistory medicalHistory);
}
