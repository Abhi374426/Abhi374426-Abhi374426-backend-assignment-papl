package com.example.Driver_Vehicle.Management.System.transformer;

import com.example.Driver_Vehicle.Management.System.dtos.requestdto.DriverRequestDto;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.DriverResponseDto;
import com.example.Driver_Vehicle.Management.System.entity.Drivers;

public class DriverTransformer {

    public static Drivers  dtoToObj(DriverRequestDto requestDto){
            return    Drivers.builder()
                       .driverCode(requestDto.getDriverCode())
                       .driverName(requestDto.getDriverName())
                       .licenceNumber(requestDto.getLicenceNumber())
                       .licenceExpiryDate(requestDto.getLicenceExpiryDate())
                       .build();
    }
    public static DriverResponseDto objToDto(Drivers drivers){
          return   DriverResponseDto.builder()
                    .driverCode(drivers.getDriverCode())
                    .driverName(drivers.getDriverName())
                    .licenceNumber(drivers.getLicenceNumber())
                    .licenceExpiryDate(drivers.getLicenceExpiryDate())
                    .build();
    }


}
