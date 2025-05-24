package com.example.Driver_Vehicle.Management.System.exceptions;

public class NotFoundExecption extends RuntimeException{

    public NotFoundExecption(){
        super("Not Found");
    }
    public NotFoundExecption(String str){
        super(str);
    }
}
