package ru.company.flot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentDto {


    @JsonProperty("EmployeeID")
    private Integer employeeId;

    @JsonProperty("PairingID")
    private Integer pairingId;

    @JsonProperty("Rank")
    private String rank;

}
