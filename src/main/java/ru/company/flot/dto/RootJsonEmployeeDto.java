package ru.company.flot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.company.flot.entity.Employee;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RootJsonEmployeeDto {

    @JsonProperty("Employees")
    private List<EmployeeDto> employees;


}
