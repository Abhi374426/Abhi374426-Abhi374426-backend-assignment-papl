package com.example.Driver_Vehicle.Management.System.transformer;

import com.example.Driver_Vehicle.Management.System.dtos.responsedto.DriverVehiclesMappingResponse;
import com.example.Driver_Vehicle.Management.System.entity.DriverVehicleMapping;

public class DriverVehicleMappingTransformer {

    public static DriverVehiclesMappingResponse objToDto(DriverVehicleMapping driverVehicleMapping){
        return DriverVehiclesMappingResponse.builder()
                .id(driverVehicleMapping.getId())
                .driverCode(driverVehicleMapping.getDrivers().getDriverCode())
                .driverName(driverVehicleMapping.getDrivers().getDriverName())
                .licenceNumber(driverVehicleMapping.getDrivers().getLicenceNumber())
                .licenceExpiryDate(driverVehicleMapping.getDrivers().getLicenceExpiryDate())
                .vehicleNumber(driverVehicleMapping.getVehicle().getVehicleNumber())
                .model(driverVehicleMapping.getVehicle().getModel())
                .manufactureDate(driverVehicleMapping.getVehicle().getManufactureDate())
                .build();
    }
}
