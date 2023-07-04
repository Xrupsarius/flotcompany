package ru.company.flot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.company.flot.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
