package ru.lims.patients.mapper;

import org.mapstruct.Mapper;
import ru.lims.patients.dto.ConsultationDto;
import ru.lims.patients.dto.ConsultationUpdateDto;
import ru.lims.patients.model.Consultation;

@Mapper(componentModel = "spring")
public interface ConsultationMapper {

    ConsultationDto toDto(Consultation consultation);

    Consultation fromDto(ConsultationUpdateDto consultationDto);
}
