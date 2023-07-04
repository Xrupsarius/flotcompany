package ru.company.flot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PairingDto {

    @JsonProperty("ID")
    private Integer id;

    @JsonProperty("Fleet")
    private String fleet;

    @JsonProperty("DateTimeStart")
    private String dateTimeStart;

    @JsonProperty("DateTimeEnd")
    private String dateTimeEnd;

}
