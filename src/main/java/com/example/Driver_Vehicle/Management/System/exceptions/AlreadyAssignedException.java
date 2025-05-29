package com.example.Driver_Vehicle.Management.System.exceptions;

public class AlreadyAssignedException extends RuntimeException{


    public AlreadyAssignedException(String msg){
        super(msg);
    }
    public AlreadyAssignedException(){
        super();
    }
}
