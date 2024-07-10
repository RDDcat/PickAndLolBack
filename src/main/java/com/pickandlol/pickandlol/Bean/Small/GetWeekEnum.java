package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.Enum.Week;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GetWeekEnum {

    public Week exec(LocalDateTime startReferenceDate, LocalDateTime createDate) {
        LocalDateTime tempDate = startReferenceDate;
        int weekNumber = 1;

        while (!createDate.isBefore(tempDate.plusWeeks(1))) {
            tempDate = tempDate.plusWeeks(1);
            weekNumber++;
        }

        return switch (weekNumber) {
            case 1 -> Week.WEEK1;
            case 2 -> Week.WEEK2;
            case 3, 4 -> Week.WEEK3;
            case 5 -> Week.WEEK4;
            case 6 -> Week.WEEK5;
            case 7 -> Week.WEEK6;
            case 8 -> Week.WEEK7;
            case 9 -> Week.WEEK8;
            case 10 -> Week.WEEK9;
            case 11 -> Week.WEEK10;
            default -> throw new IllegalArgumentException("Invalid week number: " + weekNumber);
        };
    }
}
