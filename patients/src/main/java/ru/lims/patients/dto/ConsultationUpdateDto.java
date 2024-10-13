package ru.lims.patients.dto;

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
public class ConsultationUpdateDto {

    @NotNull
    @Positive
    private long id;

    @NotNull
    @Positive(message = "ID must be more than 0")
    private long doctorId;

    @NotNull
    @Positive(message = "ID must be more than 0")
    private long medicalHistoryId;

    @NotNull
    private LocalDateTime consultationDate;

    @NotBlank
    private String consultationText;

}
