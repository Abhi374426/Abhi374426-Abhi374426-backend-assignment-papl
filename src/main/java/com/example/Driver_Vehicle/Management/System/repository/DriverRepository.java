package com.example.Driver_Vehicle.Management.System.repository;

import com.example.Driver_Vehicle.Management.System.entity.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Driver;
import java.time.LocalDate;
import java.util.List;

public interface DriverRepository extends JpaRepository<Drivers,String>{
    @Query("SELECT d FROM Drivers d WHERE d.licenceExpiryDate BETWEEN :start AND :end " +
            "AND (:name IS NULL OR TRIM(d.driverName) LIKE CONCAT('%', :name, '%'))")
    List<Drivers> findByLicenceExpiryDateBetweenAndOptionalName(
            @Param("start") LocalDate start,
            @Param("end") LocalDate end,
            @Param("name") String name);

//    List<Drivers> findByLicenceExpiryDateBetweenAndDriverName(LocalDate start, LocalDate end, String driverName);

}
