package ru.company.flot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.company.flot.dto.RootJsonEmployeeDto;
import ru.company.flot.entity.Employee;
import ru.company.flot.repository.EmployeeRepository;
import ru.company.flot.service.EmployeeService;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    @Transactional
    public List<Employee> uploadEmployees(RootJsonEmployeeDto employeeDto) {
        if (employeeDto.getEmployees().isEmpty()) return Collections.emptyList();
        List<Employee> employees = employeeDto.getEmployees().stream().map(empl -> Employee.builder()
                .id(empl.getId())
                .gender(empl.getGender())
                .fleet(empl.getFleet())
                .build()
        ).toList();
        repository.saveAll(employees);
        log.info("Uploaded employees - {}", employees);
        return employees;
    }
}
