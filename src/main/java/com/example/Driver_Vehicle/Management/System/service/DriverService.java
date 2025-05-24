package com.example.Driver_Vehicle.Management.System.service;

import com.example.Driver_Vehicle.Management.System.dtos.requestdto.DriverRequestDto;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.DriverResponseDto;

import java.util.List;

public interface DriverService {

    DriverResponseDto addDriverDetails(DriverRequestDto driverRequestDto);
    List<DriverResponseDto> getDriversWhoseLicenceIsOlderThan5Years();
}
