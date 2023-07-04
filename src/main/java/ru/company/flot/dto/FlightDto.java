package ru.company.flot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Builder
public class FlightDto {

    @JsonProperty("ID")
    private Integer id;

    @JsonProperty("FlightNum")
    private Integer flightNumber;

    @JsonProperty("StationDeparture")
    private String stationDeparture;

    @JsonProperty("StationArrival")
    private String stationArrival;

    @JsonProperty("DateTimeDeparture")
    private ZonedDateTime dateTimeDeparture;

    @JsonProperty("DateTimeArrival")
    private ZonedDateTime dateTimeArrival;

}
