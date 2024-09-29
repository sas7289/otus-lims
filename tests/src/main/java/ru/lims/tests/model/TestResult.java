package ru.lims.tests.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
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
@Table(name = "test_results")
public class TestResult {

    @Id
    private long id;

    @Column(name = "performed_date")
    private LocalDateTime performedDate;

    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "result_value")
    private int resultValue;

    @Column(name = "performed_by_employee_id")
    private long performedById;

    @Column(name = "comment")
    private String comment;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Analysis analysis;
}
