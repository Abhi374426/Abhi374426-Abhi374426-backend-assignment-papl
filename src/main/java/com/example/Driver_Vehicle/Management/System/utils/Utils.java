package com.example.Driver_Vehicle.Management.System.utils;

import java.util.UUID;

public class Utils {
    public static String generateUUID(int length){
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }
}
