package ru.lims.tests.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lims.tests.model.Biomaterial;

@Repository
public interface BiomaterialRepository extends JpaRepository<Biomaterial, Long> {

}
