package ru.company.flot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.company.flot.entity.Appointment;

import java.util.UUID;

public interface AppointmentRepository extends CrudRepository<Appointment, UUID> {
}
