package ru.lims.tests.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lims.tests.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
