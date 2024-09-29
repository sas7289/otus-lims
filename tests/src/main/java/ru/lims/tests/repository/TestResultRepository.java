package ru.lims.tests.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lims.tests.model.TestResult;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {

}
