package ru.lims.tests.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "biomaterials")
public class Biomaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "collection_date")
    private LocalDateTime collectionDate;

    @Column(name = "lab_delivery_date")
    private LocalDateTime labDeliveryDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "collector_employee_id")
    private long collectorEmployeeId;
}
