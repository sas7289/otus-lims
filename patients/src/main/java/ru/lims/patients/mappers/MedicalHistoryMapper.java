package ru.lims.patients.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.lims.patients.dto.MedicalHistoryDto;
import ru.lims.patients.models.MedicalHistory;

@Mapper(uses = ConsultationMapper.class)
public interface MedicalHistoryMapper {

    MedicalHistoryMapper INSTANCE = Mappers.getMapper(MedicalHistoryMapper.class);

    MedicalHistoryDto toDto(MedicalHistory medicalHistory);
}
