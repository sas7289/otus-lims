package ru.lims.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lims.employees.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
