package ru.lims.patients.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lims.patients.models.MedicalHistory;

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

    private MedicalHistory medicalHistory;
}
