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

        switch (weekNumber) {
            case 1: return Week.WEEK1;
            case 2: return Week.WEEK2;
            case 3: return Week.WEEK3;
            case 4: return Week.WEEK4;
            case 5: return Week.WEEK5;
            case 6: return Week.WEEK6;
            case 7: return Week.WEEK7;
            case 8: return Week.WEEK8;
            case 9: return Week.WEEK9;
            case 10: return Week.WEEK10;
            default: throw new IllegalArgumentException("Invalid week number: " + weekNumber);
        }
    }
}
