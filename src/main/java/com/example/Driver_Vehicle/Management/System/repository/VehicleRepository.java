package com.example.Driver_Vehicle.Management.System.repository;

import com.example.Driver_Vehicle.Management.System.entity.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicles,String> {

    List<Vehicles> findByManufactureDateBefore(LocalDate date);

}
