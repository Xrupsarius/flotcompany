package ru.company.flot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pairing")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pairing {

    @Id
    private Integer id;

    @Column(name = "fleet")
    private String fleet;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;
}
