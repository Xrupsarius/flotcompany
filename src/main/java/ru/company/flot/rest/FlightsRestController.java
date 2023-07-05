package ru.company.flot.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
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
    public List<Flight> uploadFlight(@RequestBody RootJsonFlightDto flightDto) {
        log.info("Started uploading flights.");
        return flightService.uploadFlights(flightDto);
    }

    @GetMapping("/get-by-employee/{id}")
    public List<Flight> getAllFlightsByEmployee(@PathVariable("id") Integer employeeId) {
        log.info("Started getting info about flight for employee - {}", employeeId);
        return flightService.getAllFlightsByEmployeeId(employeeId);
    }

}
