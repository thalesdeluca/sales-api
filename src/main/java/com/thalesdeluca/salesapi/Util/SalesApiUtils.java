package com.thalesdeluca.salesapi.Util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;

public class SalesApiUtils {
    public static LocalDate dateToLocalDate(long date){
        return Instant.ofEpochMilli(date)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
