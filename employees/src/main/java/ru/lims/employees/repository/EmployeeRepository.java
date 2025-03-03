package ru.lims.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lims.employees.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
