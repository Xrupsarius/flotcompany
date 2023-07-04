package ru.company.flot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

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
