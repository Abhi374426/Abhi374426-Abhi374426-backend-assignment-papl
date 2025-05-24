package com.example.Driver_Vehicle.Management.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "VEHICLES_TABLE")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicles {
    @Id
    private String vehicleNumber;

    private String model;

    private LocalDate manufactureDate;
}
