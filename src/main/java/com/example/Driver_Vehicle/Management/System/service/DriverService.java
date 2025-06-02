package com.example.Driver_Vehicle.Management.System.service;

import com.example.Driver_Vehicle.Management.System.dtos.requestdto.DriverRequestDto;
import com.example.Driver_Vehicle.Management.System.dtos.requestdto.SearchDto;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.DriverResponseDto;
import com.example.Driver_Vehicle.Management.System.entity.Drivers;

import java.time.LocalDate;
import java.util.List;

public interface DriverService {

    DriverResponseDto addDriverDetails(DriverRequestDto driverRequestDto);
    List<DriverResponseDto> getDriversWhoseLicenceIsOlderThan5Years();
    List<Drivers>  findByLicenceExpiryDateBetweenAndOptionalName(SearchDto searchDto);
}
