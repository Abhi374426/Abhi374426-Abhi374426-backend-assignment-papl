package com.example.Driver_Vehicle.Management.System.transformer;

import com.example.Driver_Vehicle.Management.System.dtos.requestdto.DriverRequestDto;
import com.example.Driver_Vehicle.Management.System.dtos.requestdto.VehiclesRequestDto;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.DriverResponseDto;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.VehiclesResponseDto;
import com.example.Driver_Vehicle.Management.System.entity.Drivers;
import com.example.Driver_Vehicle.Management.System.entity.Vehicles;

public class VehiclesTransformer {

    public static Vehicles dtoToObj(VehiclesRequestDto requestDto){
        return Vehicles.builder()
                .model(requestDto.getModel())
                .vehicleNumber(requestDto.getVehicleNumber())
                .manufactureDate(requestDto.getManufactureDate())
                .build();
    }
    public static VehiclesResponseDto objToDto(Vehicles vehicles){
        return   VehiclesResponseDto.builder()
                .model(vehicles.getModel())
                .manufactureDate(vehicles.getManufactureDate())
                .vehicleNumber(vehicles.getVehicleNumber())
                .build();
    }
}
