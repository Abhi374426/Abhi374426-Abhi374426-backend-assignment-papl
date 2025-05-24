package com.example.Driver_Vehicle.Management.System.dtos.responsedto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehiclesResponseDto {
    private String vehicleNumber;

    private String model;

    private LocalDate manufactureDate;
}
