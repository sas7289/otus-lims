package ru.lims.employees.mapper;

import org.mapstruct.Mapper;
import ru.lims.employees.dto.EmployeeDto;
import ru.lims.employees.model.Employee;

@Mapper(componentModel = "spring", uses = DepartmentMapper.class)
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);
}
