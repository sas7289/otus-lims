package ru.lims.patients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lims.patients.model.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
