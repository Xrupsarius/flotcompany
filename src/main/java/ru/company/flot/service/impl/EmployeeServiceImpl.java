package ru.company.flot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.company.flot.dto.RootJsonEmployeeDto;
import ru.company.flot.entity.Employee;
import ru.company.flot.repository.EmployeeRepository;
import ru.company.flot.service.EmployeeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    @Transactional
    public List<Employee> downloadEmployees(RootJsonEmployeeDto employeeDto) {
        List<Employee> employees = employeeDto.getEmployees().stream().map(empl -> Employee.builder()
                .id(empl.getId())
                .gender(empl.getGender())
                .fleet(empl.getFleet())
                .build()
        ).toList();
        repository.saveAll(employees);
        return employees;
    }
}
