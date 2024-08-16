package com.pickandlol.pickandlol.Others;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeUtil {
    public static LocalDateTime exec() {
        return ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toLocalDateTime();
    }
}
