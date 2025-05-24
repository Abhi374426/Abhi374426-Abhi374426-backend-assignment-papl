package com.example.Driver_Vehicle.Management.System.controller;

import com.example.Driver_Vehicle.Management.System.contstant.Messages;
import com.example.Driver_Vehicle.Management.System.dtos.requestdto.DriverRequestDto;
import com.example.Driver_Vehicle.Management.System.dtos.requestdto.VehiclesRequestDto;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.DriverResponseDto;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.VehiclesResponseDto;
import com.example.Driver_Vehicle.Management.System.response_api.ResponseApi;
import com.example.Driver_Vehicle.Management.System.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<ResponseApi<VehiclesResponseDto>> addVehicle(@RequestBody VehiclesRequestDto requestDto) {
        ResponseApi<VehiclesResponseDto> responseApi=ResponseApi.<VehiclesResponseDto>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(vehicleService.addVehicleDetails(requestDto))
                .build();
        return new ResponseEntity<>(responseApi,HttpStatus.OK);
    }
    @GetMapping("/older-than-5-years")
    public ResponseEntity<ResponseApi<List<VehiclesResponseDto>>> getVehiclesOlderThan() {
        ResponseApi<List<VehiclesResponseDto>> responseApi=ResponseApi.<List<VehiclesResponseDto>>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(vehicleService.getVehiclesOlderThanFiveYears())
                .build();
        return new ResponseEntity<>(responseApi,HttpStatus.OK);
    }

}
