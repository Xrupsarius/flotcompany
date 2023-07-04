package ru.company.flot.service;

import ru.company.flot.dto.RootJsonEmployeeDto;
import ru.company.flot.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> downloadEmployees(RootJsonEmployeeDto employeeDto);

}
