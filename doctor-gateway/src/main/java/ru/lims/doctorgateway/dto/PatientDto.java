package ru.lims.doctorgateway.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDto {
    private long id;

    private String name;

    private String lastName;

    private String middleName;

    private String gender;

    private String dateOfBirth;

    private String phoneNumber;

    private String address;

    private String email;

    private MedicalHistoryDto medicalHistory;
}
