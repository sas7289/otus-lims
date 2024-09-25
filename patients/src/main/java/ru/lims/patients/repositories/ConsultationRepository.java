package ru.lims.patients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lims.patients.models.Patient;

public interface ConsultationRepository extends JpaRepository<Patient, Long> {

}
