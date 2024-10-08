package ru.lims.patients.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultationUpdateDto {

    private long id;

    private long doctorId;

    private long medicalHistoryId;

    private LocalDateTime consultationDate;

    private String consultationText;

}
