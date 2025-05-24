package com.example.Driver_Vehicle.Management.System.dtos.responsedto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverResponseDto {

    private String driverCode;

    private String driverName;

    private String licenceNumber;

    private LocalDate licenceExpiryDate;

}
