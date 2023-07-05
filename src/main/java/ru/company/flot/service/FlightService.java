package ru.company.flot.service;

import ru.company.flot.dto.RootJsonFlightDto;
import ru.company.flot.entity.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> uploadFlights(RootJsonFlightDto flightDto);

    List<Flight> getAllFlightsByEmployeeId(Integer employeeId);
}
