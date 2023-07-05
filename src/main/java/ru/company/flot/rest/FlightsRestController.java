package ru.company.flot.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.company.flot.dto.RootJsonFlightDto;
import ru.company.flot.entity.Flight;
import ru.company.flot.service.FlightService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightsRestController {

    private final FlightService flightService;


    @PostMapping("/upload")
    public List<Flight> uploadFlight(RootJsonFlightDto flightDto) {
        log.info("Started uploading flights.");
        return flightService.uploadFlights(flightDto);
    }

}
