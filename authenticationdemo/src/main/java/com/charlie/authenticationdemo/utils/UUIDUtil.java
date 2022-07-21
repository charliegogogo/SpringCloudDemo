package com.charlie.authenticationdemo.utils;

import java.util.UUID;

public class UUIDUtil {

    public static String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
