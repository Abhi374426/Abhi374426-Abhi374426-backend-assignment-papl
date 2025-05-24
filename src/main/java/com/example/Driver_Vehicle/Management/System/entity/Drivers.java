package com.example.Driver_Vehicle.Management.System.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "DRIVER_TABLE")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Drivers {
    @Id
    private String driverCode;

    private String driverName;

    @Column(unique = true)
    private String licenceNumber;

    private LocalDate licenceExpiryDate;
}
