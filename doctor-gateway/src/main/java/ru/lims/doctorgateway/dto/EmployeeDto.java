package ru.lims.doctorgateway.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeDto {

    private long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private DepartmentDto department;

    private String position;
}
