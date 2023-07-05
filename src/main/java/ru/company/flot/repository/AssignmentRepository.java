package ru.company.flot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.company.flot.entity.Assignment;

import java.util.List;
import java.util.UUID;

public interface AssignmentRepository extends CrudRepository<Assignment, UUID> {

    List<Assignment> findByEmployeeId(Integer employeeId);

}
