package ru.lims.employees.mapper;

import org.mapstruct.Mapper;
import ru.lims.employees.dto.DepartmentDto;
import ru.lims.employees.dto.EmployeeDto;
import ru.lims.employees.model.Department;
import ru.lims.employees.model.Employee;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentDto toDto(Department department);
}
