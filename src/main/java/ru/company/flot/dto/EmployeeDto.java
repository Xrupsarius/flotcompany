package ru.company.flot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

    @JsonProperty("ID")
    private Integer id;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("Fleet")
    private String fleet;

}
