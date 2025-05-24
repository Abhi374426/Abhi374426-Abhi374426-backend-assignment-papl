package com.example.Driver_Vehicle.Management.System.repository;

import com.example.Driver_Vehicle.Management.System.entity.DriverVehicleMapping;
import com.example.Driver_Vehicle.Management.System.entity.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DriverVehicleMappingRepository extends JpaRepository<DriverVehicleMapping,String> {

    List<DriverVehicleMapping> findByVehicle_ManufactureDateLessThanEqual(LocalDate date);

}
