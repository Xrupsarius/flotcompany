package ru.company.flot.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.company.flot.dto.RootJsonEmployeeDto;
import ru.company.flot.entity.Employee;
import ru.company.flot.service.EmployeeService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @PostMapping("/download")
    public List<Employee> downloadEmployees(@RequestBody RootJsonEmployeeDto employeeDto) {
        log.info("We get the root object - {}", employeeDto);
        return employeeService.downloadEmployees(employeeDto);
    }

}
