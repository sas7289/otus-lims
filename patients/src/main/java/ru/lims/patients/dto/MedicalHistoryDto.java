package ru.lims.patients.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicalHistoryDto {

    private long id;

    private String historyNumber;

    private String  insurancePolicyNumber;

    private List<ConsultationDto> consultations;

}
