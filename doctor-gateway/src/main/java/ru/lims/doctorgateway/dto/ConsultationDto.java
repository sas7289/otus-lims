package ru.lims.doctorgateway.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultationDto {

    private long id;

    private long doctorId;

    private LocalDateTime consultationDate;

    private String consultationText;

}
