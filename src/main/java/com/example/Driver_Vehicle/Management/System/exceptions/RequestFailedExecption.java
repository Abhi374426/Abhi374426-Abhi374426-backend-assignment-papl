package com.example.Driver_Vehicle.Management.System.exceptions;

public class RequestFailedExecption extends RuntimeException{

    public RequestFailedExecption(String msg){
        super(msg);
    }
    public RequestFailedExecption(){
        super();
    }
}
