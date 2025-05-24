package com.example.Driver_Vehicle.Management.System.service;

import com.example.Driver_Vehicle.Management.System.dtos.requestdto.VehiclesRequestDto;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.VehiclesResponseDto;

import java.util.List;

public interface VehicleService {

    VehiclesResponseDto  addVehicleDetails(VehiclesRequestDto requestDto);
    List<VehiclesResponseDto>  getVehiclesOlderThanFiveYears();
}
