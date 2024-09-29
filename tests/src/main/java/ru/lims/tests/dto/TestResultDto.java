package ru.lims.tests.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestResultDto {

    private long id;

    private LocalDateTime performedDate;

    private long patientId;

    private int resultValue;

    private long performedById;

    private String comment;
}
