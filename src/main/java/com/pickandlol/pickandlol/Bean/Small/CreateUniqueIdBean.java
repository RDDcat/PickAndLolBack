package com.pickandlol.pickandlol.Bean.Small;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CreateUniqueIdBean {

    // 해시로 Unique한 데이터 값 받기
    public String exec(){
        // 아이디 객체 생성
        Random random = new Random();

        // 아이디 객체의 hash값으로 유니크한 아이디값 생성 후 반환
        Long number = random.nextLong() & Long.MAX_VALUE;

        return number.toString();
    }
}
