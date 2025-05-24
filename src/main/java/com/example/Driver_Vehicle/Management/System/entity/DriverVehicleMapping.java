package com.example.Driver_Vehicle.Management.System.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Driver;

@Entity
@Table(name = "DRIVER_VEHICLES_MANAGEMENT")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverVehicleMapping {
    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "driver_code", referencedColumnName = "driverCode")
    private Drivers drivers;

    @OneToOne
    @JoinColumn(name = "vehicle_number", referencedColumnName = "vehicleNumber", unique = true)
    private Vehicles vehicle;

}
