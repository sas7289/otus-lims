package ru.lims.doctorgateway.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BiomaterialDto {

    private long id;

    private String type;

    private LocalDateTime collectionDate;

    private LocalDateTime labDeliveryDate;

    private String comment;

    private long collectorEmployeeId;
}
