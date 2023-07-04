package ru.company.flot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RootJsonRosterDto {

    @JsonProperty("Pairings")
    private List<PairingDto> pairings;

}
