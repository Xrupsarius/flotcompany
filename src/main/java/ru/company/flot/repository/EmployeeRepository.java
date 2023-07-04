package ru.company.flot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.company.flot.entity.Employee;

import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
