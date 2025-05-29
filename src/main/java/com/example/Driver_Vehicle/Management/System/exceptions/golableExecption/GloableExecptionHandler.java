package com.example.Driver_Vehicle.Management.System.exceptions.golableExecption;

import com.example.Driver_Vehicle.Management.System.exceptions.AlreadyAssignedException;
import com.example.Driver_Vehicle.Management.System.exceptions.NotFoundExecption;
import com.example.Driver_Vehicle.Management.System.exceptions.RequestFailedExecption;
import com.example.Driver_Vehicle.Management.System.response_api.ResponseApi;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloableExecptionHandler {
 @ExceptionHandler(NotFoundExecption.class)
 public ResponseEntity<ResponseApi<Object>> notFoundExecption(NotFoundExecption exp){
   ResponseApi<Object> responseApi=ResponseApi.builder()
           .message(exp.getMessage())
           .status(HttpStatus.NOT_FOUND.value())
           .build();
    return  new ResponseEntity<>(responseApi,HttpStatus.NOT_FOUND);
 }
    @ExceptionHandler(RequestFailedExecption.class)
    public ResponseEntity<ResponseApi<Object>> notFoundExecption(RequestFailedExecption exp){
        ResponseApi<Object> responseApi=ResponseApi.builder()
                .message(exp.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return  new ResponseEntity<>(responseApi,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AlreadyAssignedException.class)
    public ResponseEntity<ResponseApi<Object>> notFoundExecption(AlreadyAssignedException exp){
        ResponseApi<Object> responseApi=ResponseApi.builder()
                .message(exp.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .build();
        return  new ResponseEntity<>(responseApi,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseApi<String>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        return new ResponseEntity<>(
                ResponseApi.<String>builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message("Driver or Vehicle already assigned.")
                        .data(null)
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseApi<Object>> handleAllExceptions(Exception ex) {

        ResponseApi<Object> response = ResponseApi.<Object>builder()
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
