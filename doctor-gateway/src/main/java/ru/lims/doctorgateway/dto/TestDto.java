package ru.lims.doctorgateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestDto {

    private long id;

    private String name;

    private String type;

    private String materialType;

    private int minReferenceValue;

    private int maxReferenceValue;
}