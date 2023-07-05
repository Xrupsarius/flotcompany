package ru.company.flot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.company.flot.entity.Flight;

import java.util.UUID;

public interface FlightRepository extends CrudRepository<Flight, UUID> {

    Flight findByStartFlightAndEndFlight(String startTime, String endTime);

}
