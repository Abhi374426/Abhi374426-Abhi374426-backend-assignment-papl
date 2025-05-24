package com.example.Driver_Vehicle.Management.System.service.Imp;

import com.example.Driver_Vehicle.Management.System.dtos.requestdto.VehiclesRequestDto;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.VehiclesResponseDto;
import com.example.Driver_Vehicle.Management.System.entity.Vehicles;
import com.example.Driver_Vehicle.Management.System.repository.VehicleRepository;
import com.example.Driver_Vehicle.Management.System.service.VehicleService;
import com.example.Driver_Vehicle.Management.System.transformer.VehiclesTransformer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public VehiclesResponseDto addVehicleDetails(VehiclesRequestDto requestDto) {
        Vehicles vehicles= VehiclesTransformer.dtoToObj(requestDto);
        return VehiclesTransformer.objToDto( vehicleRepository.save(vehicles));
    }

    @Override
    public List<VehiclesResponseDto> getVehiclesOlderThanFiveYears() {
      LocalDate minDate=LocalDate.now().minusYears(5);
    List<Vehicles> vehicles= vehicleRepository.findByManufactureDateBefore(minDate);
    return vehicles.stream().map(VehiclesTransformer::objToDto).collect(Collectors.toList());
    }

}
