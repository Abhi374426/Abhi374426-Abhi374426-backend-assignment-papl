package com.example.Driver_Vehicle.Management.System.controller;

import com.example.Driver_Vehicle.Management.System.contstant.Messages;
import com.example.Driver_Vehicle.Management.System.dtos.requestdto.DriverVehiclesMappingRequest;
import com.example.Driver_Vehicle.Management.System.dtos.requestdto.VehiclesRequestDto;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.DriverVehiclesMappingResponse;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.VehiclesResponseDto;
import com.example.Driver_Vehicle.Management.System.entity.Vehicles;
import com.example.Driver_Vehicle.Management.System.response_api.ResponseApi;
import com.example.Driver_Vehicle.Management.System.service.DriverVehicleMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class MappingController {
    @Autowired
    private DriverVehicleMappingService driverVehicleMappingService;

    @PostMapping
    public ResponseEntity<ResponseApi<DriverVehiclesMappingResponse>> addMapping(@RequestBody DriverVehiclesMappingRequest driverVehiclesMappingRequest) {
        ResponseApi<DriverVehiclesMappingResponse> responseApi=ResponseApi.<DriverVehiclesMappingResponse>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(driverVehicleMappingService.addDetails(driverVehiclesMappingRequest))
                .build();
        return new ResponseEntity<>(responseApi,HttpStatus.OK);
    }
    @GetMapping("/older-than-5-years-with-new-license-drivers")
    public ResponseEntity<ResponseApi<List<Vehicles>>> getVehiclesOlderThan5YearsWithLessThan3YearLicenseDrivers() {
        ResponseApi<List<Vehicles>> responseApi=ResponseApi.<List<Vehicles>>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(driverVehicleMappingService.getVehiclesOlderThan5YearsWithNewLicenseDrivers())
                .build();
        return new ResponseEntity<>(responseApi,HttpStatus.OK);
    }
}
