package com.example.Driver_Vehicle.Management.System.response_api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseApi<T> {

    private String message;
    private int status;
    private T data;

}
