package ru.company.flot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Table(name = "flight")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private String startFlight;

    @Column(name = "end_flight")
    private String endFlight;

}
