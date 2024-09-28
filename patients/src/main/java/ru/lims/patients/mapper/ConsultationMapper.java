package ru.lims.patients.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.lims.patients.dto.ConsultationDto;
import ru.lims.patients.model.Consultation;

@Mapper
public interface ConsultationMapper {

    ConsultationMapper INSTANCE = Mappers.getMapper(ConsultationMapper.class);

    ConsultationDto toDto(Consultation medicalHistory);
}
