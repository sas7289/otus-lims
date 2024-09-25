package ru.lims.patients.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "medical_history")
public class MedicalHistory {

    @Id
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Patient patient;

    @Column(name = "history_number")
    private String historyNumber;

    @Column(name = "insurance_policy_number")
    private String  insurancePolicyNumber;

    @OneToMany(mappedBy = "medicalHistory")
    private List<Consultation> consultations;

}
