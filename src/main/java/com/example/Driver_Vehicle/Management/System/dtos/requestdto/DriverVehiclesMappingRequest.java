package com.example.Driver_Vehicle.Management.System.dtos.requestdto;

import com.example.Driver_Vehicle.Management.System.exceptions.RequestFailedExecption;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DriverVehiclesMappingRequest {
    private String driverCode;
    private String vehicleNumber;


    public void validate() {
        if (driverCode == null || driverCode.trim().isEmpty()) {
            throw new RequestFailedExecption("Driver Code must not be empty");
        }
        if (vehicleNumber == null || vehicleNumber.trim().isEmpty()) {
            throw new RequestFailedExecption("Vehicle Number must not be empty");
        }
    }
}
