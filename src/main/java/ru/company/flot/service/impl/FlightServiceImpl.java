package ru.company.flot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.company.flot.dto.RootJsonFlightDto;
import ru.company.flot.entity.Flight;
import ru.company.flot.repository.FlightRepository;
import ru.company.flot.service.FlightService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository repository;

    @Override
    @Transactional
    public List<Flight> uploadFlights(RootJsonFlightDto flightDto) {
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
}
