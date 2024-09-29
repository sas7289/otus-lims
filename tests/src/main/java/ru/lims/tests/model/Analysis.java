package ru.lims.tests.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "analyzes")
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "biomaterial_id")
    private Biomaterial biomaterial;

    @Column(name = "status")
    private String status;

    @Column(name = "performed_by_employee_id")
    private long performedById;

    @OneToOne(mappedBy = "analysis")
    private TestResult testResult;

    @Column(name = "patient_id")
    private long patientId;
}
