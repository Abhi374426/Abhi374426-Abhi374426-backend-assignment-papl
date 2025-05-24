package com.example.Driver_Vehicle.Management.System.service.Imp;

import com.example.Driver_Vehicle.Management.System.contstant.Messages;
import com.example.Driver_Vehicle.Management.System.dtos.requestdto.DriverVehiclesMappingRequest;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.DriverVehiclesMappingResponse;
import com.example.Driver_Vehicle.Management.System.entity.DriverVehicleMapping;
import com.example.Driver_Vehicle.Management.System.entity.Drivers;
import com.example.Driver_Vehicle.Management.System.entity.Vehicles;
import com.example.Driver_Vehicle.Management.System.exceptions.NotFoundExecption;
import com.example.Driver_Vehicle.Management.System.repository.DriverRepository;
import com.example.Driver_Vehicle.Management.System.repository.DriverVehicleMappingRepository;
import com.example.Driver_Vehicle.Management.System.repository.VehicleRepository;
import com.example.Driver_Vehicle.Management.System.service.DriverVehicleMappingService;
import com.example.Driver_Vehicle.Management.System.transformer.DriverVehicleMappingTransformer;
import com.example.Driver_Vehicle.Management.System.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DriverVehicleMappingServiceImpl implements DriverVehicleMappingService {
    @Autowired
    private DriverVehicleMappingRepository driverVehicleMappingRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public DriverVehiclesMappingResponse addDetails(DriverVehiclesMappingRequest dto) {
        Drivers driver = driverRepository.findById(dto.getDriverCode())
                .orElseThrow(() -> new NotFoundExecption(Messages.DRIVER + Messages.ONE_SPACE + Messages.NOT_FOUND));

        Vehicles vehicle = vehicleRepository.findById(dto.getVehicleNumber())
                .orElseThrow(() -> new NotFoundExecption(Messages.VEHICLE + Messages.ONE_SPACE + Messages.NOT_FOUND));
        DriverVehicleMapping driverVehicleMapping = new DriverVehicleMapping();
        driverVehicleMapping.setId(Utils.generateUUID(8));
        driverVehicleMapping.setDrivers(driver);
        driverVehicleMapping.setVehicle(vehicle);
        return DriverVehicleMappingTransformer.objToDto(driverVehicleMappingRepository.save(driverVehicleMapping));
    }

    @Override
    public List<Vehicles> getVehiclesOlderThan5YearsWithNewLicenseDrivers() {
        LocalDate minDate=LocalDate.now().minusYears(5);
           List<DriverVehicleMapping> vehicles=  driverVehicleMappingRepository.findByVehicle_ManufactureDateLessThanEqual(minDate);
         return vehicles.stream()
                  .filter(driverVehicleMapping -> {
                      LocalDate expiryDate = driverVehicleMapping.getDrivers().getLicenceExpiryDate();
                      LocalDate issueDate = expiryDate.minusYears(20);
                      return issueDate.isAfter(LocalDate.now().minusYears(3));
                  }).map(DriverVehicleMapping::getVehicle)
                  .collect(Collectors.toList());

    }
}
