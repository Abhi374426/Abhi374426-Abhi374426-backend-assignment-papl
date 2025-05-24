package com.example.Driver_Vehicle.Management.System.service;

import com.example.Driver_Vehicle.Management.System.dtos.requestdto.DriverVehiclesMappingRequest;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.DriverVehiclesMappingResponse;
import com.example.Driver_Vehicle.Management.System.entity.Vehicles;

import java.util.List;

public interface DriverVehicleMappingService {

    DriverVehiclesMappingResponse  addDetails(DriverVehiclesMappingRequest dto);
    List<Vehicles>    getVehiclesOlderThan5YearsWithNewLicenseDrivers();
}
