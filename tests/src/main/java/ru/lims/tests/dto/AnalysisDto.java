package ru.lims.tests.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnalysisDto {

    private long id;

    private LocalDateTime appointmentDate;

    private TestDto test;

    private BiomaterialDto biomaterial;

    private String status;

    private long performedById;

    private TestResultDto testResult;

    private long patientId;
}
