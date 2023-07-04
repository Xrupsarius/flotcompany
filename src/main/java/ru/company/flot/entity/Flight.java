package ru.company.flot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "flight")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    private Integer id;

    @Column(name = "flight_number")
    private Integer flightNumber;

    @Column(name = "airport_from")
    private String airportFrom;

    @Column(name = "airport_to")
    private String airportTo;

    @Column(name = "start_flight")
    private ZonedDateTime startFlight;

    @Column(name = "end_flight")
    private ZonedDateTime endFlight;

}
