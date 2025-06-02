package com.example.Driver_Vehicle.Management.System.dtos.requestdto;

import com.example.Driver_Vehicle.Management.System.exceptions.RequestFailedExecption;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class DriverRequestDto {
    private String driverCode;

    private String driverName;

    private String licenceNumber;

    private LocalDate licenceExpiryDate;

    public String getTrimmedDriverName() {
        return driverName != null ? driverName.trim() : null;
    }
    public  void validate(){

            if (driverCode == null || driverCode.trim().isEmpty()) {
                throw new RequestFailedExecption("Driver Code name must not be empty");
            }
            if (driverName == null || driverName.trim().isEmpty()) {
                throw new RequestFailedExecption("Driver name must not be empty");
            }
            if (licenceNumber == null || licenceNumber.trim().isEmpty()) {
                throw new RequestFailedExecption("Licence number must not be empty");
            }
            if (licenceExpiryDate == null) {
                throw new RequestFailedExecption("Licence expiry date is required");
            }
            if (licenceExpiryDate.isBefore(LocalDate.now())) {
                throw new RequestFailedExecption("Licence expiry date must be in the future");
            }
    }
}
