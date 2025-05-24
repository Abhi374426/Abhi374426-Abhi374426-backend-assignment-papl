package com.example.Driver_Vehicle.Management.System.dtos.requestdto;

import com.example.Driver_Vehicle.Management.System.exceptions.RequestFailedExecption;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class VehiclesRequestDto {
    private String vehicleNumber;

    private String model;

    private LocalDate manufactureDate;

    public void validate() {
        if (vehicleNumber == null || vehicleNumber.trim().isEmpty()) {
            throw new RequestFailedExecption("Vehicle Number must not be empty");
        }
        if (model == null || model.trim().isEmpty()) {
            throw new RequestFailedExecption("Model must not be empty");
        }
        if (manufactureDate == null) {
            throw new RequestFailedExecption("Manufacture Date must not be null");
        }
    }

}
