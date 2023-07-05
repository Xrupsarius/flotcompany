package ru.company.flot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.company.flot.dto.RootJsonFlightDto;
import ru.company.flot.entity.Flight;
import ru.company.flot.entity.Pairing;
import ru.company.flot.repository.FlightRepository;
import ru.company.flot.service.FlightService;
import ru.company.flot.service.PairingService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository repository;
    private final PairingService pairingService;

    @Override
    @Transactional
    public List<Flight> uploadFlights(RootJsonFlightDto flightDto) {
        if (flightDto.getFlights().isEmpty()) {
            return Collections.emptyList();
        }
        List<Flight> flights = flightDto.getFlights().stream().map(dto -> Flight.builder()
                .id(dto.getId())
                .flightNumber(dto.getFlightNumber())
                .airportFrom(dto.getStationDeparture())
                .airportTo(dto.getStationArrival())
                .startFlight(dto.getDateTimeDeparture())
                .endFlight(dto.getDateTimeArrival())
                .build()
        ).toList();
        repository.saveAll(flights);
        log.info("Uploaded flights - {}", flights);
        return flights;
    }


    @Override
    @Transactional
    public List<Flight> getAllFlightsByEmployeeId(Integer employeeId) {
        List<Pairing> allPairingsByEmployeeId = pairingService.getAllPairingsByEmployeeId(employeeId);
        List<Flight> employeeFlights = new ArrayList<>();
        allPairingsByEmployeeId.forEach(pairing -> employeeFlights.add(
                repository.findByStartFlightAndEndFlight(pairing.getStartTime(), pairing.getEndTime())
        ));
        log.info("Get the all flights for employee - {}", employeeFlights);
        return employeeFlights;

    }
}
