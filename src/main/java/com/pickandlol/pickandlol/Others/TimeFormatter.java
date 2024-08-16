package com.pickandlol.pickandlol.Others;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeFormatter {

    public String exec(){

            // 현재 날짜와 시간 가져오기
            LocalDateTime now = DateTimeUtil.exec();

            // 원하는 형식 정의
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

            // 형식에 맞춰 문자열로 변환
            return now.format(formatter);
    }

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
