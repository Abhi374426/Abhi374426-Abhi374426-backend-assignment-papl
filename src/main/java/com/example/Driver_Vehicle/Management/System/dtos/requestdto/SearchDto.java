package com.example.Driver_Vehicle.Management.System.dtos.requestdto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class SearchDto {

    private LocalDate startDate;
    private LocalDate endDate;
    private String driverName;

    public String getTrimmedDriverName() {
        return driverName != null ? driverName.trim() : null;
    }
}
