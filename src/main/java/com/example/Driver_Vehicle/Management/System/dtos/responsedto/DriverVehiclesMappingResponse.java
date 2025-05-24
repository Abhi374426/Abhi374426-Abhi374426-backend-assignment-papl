package com.example.Driver_Vehicle.Management.System.dtos.responsedto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverVehiclesMappingResponse {



        private String id;

        private String driverCode;
        private String driverName;
        private String licenceNumber;
        private LocalDate licenceExpiryDate;

        private String vehicleNumber;
        private String model;
        private LocalDate manufactureDate;


}
