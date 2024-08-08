package com.pickandlol.pickandlol.Others;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeFormatter {

    public LocalDateTime exec(String time){

        // 날짜 형식 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        return LocalDateTime.parse(time, formatter);
    }

    public Integer exec(LocalDateTime time){

        // 날짜 형식 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        String format = time.format(formatter);

        return Integer.parseInt(format);
    }
}
