package ru.company.flot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private String dateTimeDeparture;

    @JsonProperty("DateTimeArrival")
    private String dateTimeArrival;

}
