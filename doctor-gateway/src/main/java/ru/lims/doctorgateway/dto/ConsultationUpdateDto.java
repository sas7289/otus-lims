package ru.lims.doctorgateway.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultationUpdateDto {

    @NotNull
    @Positive(message = "ID must be more than 0")
    private Long id;

    @NotNull
    @Positive(message = "ID must be more than 0")
    private Long doctorId;

    @NotNull
    @Positive(message = "ID must be more than 0")
    private Long medicalHistoryId;

    @NotNull
    private LocalDateTime consultationDate;

    @NotBlank
    private String consultationText;

    private List<AnalysisDto> analyzes;

}
