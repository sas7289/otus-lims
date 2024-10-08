package ru.lims.doctorgateway.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GlobalPatientDto {

    private PatientDto patient;

    private EmployeeDto employee;

    private List<AnalysisDto> analysisDto;
}
