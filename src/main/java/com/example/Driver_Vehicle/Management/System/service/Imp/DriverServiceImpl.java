package com.example.Driver_Vehicle.Management.System.service.Imp;

import com.example.Driver_Vehicle.Management.System.contstant.Messages;
import com.example.Driver_Vehicle.Management.System.dtos.requestdto.DriverRequestDto;
import com.example.Driver_Vehicle.Management.System.dtos.requestdto.SearchDto;
import com.example.Driver_Vehicle.Management.System.dtos.responsedto.DriverResponseDto;
import com.example.Driver_Vehicle.Management.System.entity.Drivers;
import com.example.Driver_Vehicle.Management.System.exceptions.AlreadyAssignedException;
import com.example.Driver_Vehicle.Management.System.repository.DriverRepository;
import com.example.Driver_Vehicle.Management.System.service.DriverService;
import com.example.Driver_Vehicle.Management.System.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public DriverResponseDto addDriverDetails(DriverRequestDto driverRequestDto) {
        driverRequestDto.validate();
        if (driverRepository.existsById(driverRequestDto.getDriverCode()))
            throw new AlreadyAssignedException(Messages.DRIVER + ": Already exists details");
        Drivers drivers = DriverTransformer.dtoToObj(driverRequestDto);
        return DriverTransformer.objToDto(driverRepository.save(drivers));
    }

    @Override
    public List<DriverResponseDto> getDriversWhoseLicenceIsOlderThan5Years() {
        List<Drivers> alldrivers = driverRepository.findAll();
        return alldrivers.stream()
                .filter(driver -> {
                    LocalDate expDate = driver.getLicenceExpiryDate();
                    LocalDate issueDate = expDate.minusYears(20);
                    Period period = Period.between(issueDate, LocalDate.now());
                    return period.getYears() > 5;
                }).map(DriverTransformer::objToDto).collect(Collectors.toList());
    }

    @Override
    public List<Drivers> findByLicenceExpiryDateBetweenAndOptionalName(SearchDto searchDto) {
        System.out.println("start: " + searchDto.getStartDate());
        System.out.println("end: " + searchDto.getEndDate());
        System.out.println("name: " + searchDto.getDriverName());

        return driverRepository.findByLicenceExpiryDateBetweenAndOptionalName(searchDto.getStartDate(),searchDto.getEndDate(),searchDto.getDriverName());
    }

}
