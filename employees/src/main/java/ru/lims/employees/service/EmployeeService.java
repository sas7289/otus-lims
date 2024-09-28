package ru.lims.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lims.employees.dto.EmployeeDto;
import ru.lims.employees.exception.ObjectNotFoundException;
import ru.lims.employees.mapper.EmployeeMapper;
import ru.lims.employees.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDto getEmployee(long id) {
        return employeeRepository.findById(id)
            .map(employeeMapper::toDto)
            .orElseThrow(() -> new ObjectNotFoundException("Employee not found by id: " + id));
    }
}
