package ru.lims.tests.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnalysisDto {

    @NotNull
    @Positive
    private long id;

    @NotNull
    private LocalDateTime appointmentDate;

    private TestDto test;

    private BiomaterialDto biomaterial;

    @NotBlank
    private String status;

    @NotNull
    @Positive
    private long performedById;

    private TestResultDto testResult;

    @NotNull
    @Positive
    private long patientId;
}
