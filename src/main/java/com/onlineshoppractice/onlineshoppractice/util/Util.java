package com.onlineshoppractice.onlineshoppractice.util;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Util {
    public static Date getCurrentDate() {
        return new Date();
    }

}
