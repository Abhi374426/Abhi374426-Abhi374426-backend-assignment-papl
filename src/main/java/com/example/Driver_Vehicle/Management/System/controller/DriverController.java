package com.example.Driver_Vehicle.Management.System.controller;

import com.example.Driver_Vehicle.Management.System.contstant.Messages;
import com.example.Driver_Vehicle.Management.System.dtos.requestdto.DriverRequestDto;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.DriverResponseDto;
import com.example.Driver_Vehicle.Management.System.response_api.ResponseApi;
import com.example.Driver_Vehicle.Management.System.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @PostMapping
    public ResponseEntity<ResponseApi<DriverResponseDto>> addDriver(@RequestBody DriverRequestDto  driverRequestDto) {
        ResponseApi<DriverResponseDto> responseApi=ResponseApi.<DriverResponseDto>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(driverService.addDriverDetails(driverRequestDto))
                .build();
        return new ResponseEntity<>(responseApi,HttpStatus.OK);
    }
    @GetMapping("/older-than-5-years")
    public ResponseEntity<ResponseApi<List<DriverResponseDto>>> getExperiencedDrivers() {
        ResponseApi<List<DriverResponseDto>> responseApi=ResponseApi.<List<DriverResponseDto>>builder()
                .message(Messages.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(driverService.getDriversWhoseLicenceIsOlderThan5Years())
                .build();
        return new ResponseEntity<>(responseApi,HttpStatus.OK);
    }


}
